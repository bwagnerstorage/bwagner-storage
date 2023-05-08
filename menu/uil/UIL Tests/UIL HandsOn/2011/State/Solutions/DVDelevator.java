import java.io.*;
import java.util.*;


public class DVDelevator
{
    // Constants for readability
    public static final long KB = 1024;
    public static final long MB = KB * KB;
    public static final long GB = MB * KB;
    
    public static final long MILLISECONDS_TO_MICROSECONDS = 1000;
    public static final long MICROSECONDS_PER_BATCH = 10 * MILLISECONDS_TO_MICROSECONDS;
    
    public static final long DISK_SIZE = 8 * GB;
    public static final long SECTOR_SIZE = 64 * KB;
    public static final long READ_PER_SEC = 20 * MB;
    public static final long SECTOR_PER_SEC = READ_PER_SEC / SECTOR_SIZE;
    public static final long SECTOR_PER_DISK = DISK_SIZE / SECTOR_SIZE;
    
    
    // Members
    private long mElapsedMicroseconds;
    private long mBatchEndMicrosecond;
    private long mLaserPos;
    private ArrayList<ReadRequest> mBatch;
    
    
    // "Struct" with Comparable to sort
    private class ReadRequest implements Comparable<ReadRequest>
    {
        public long mStartTimeMicroseconds;
        public long mSectorStart;
        public long mSectorEnd;
        
        public int compareTo(ReadRequest o)
        {
            long diff = this.mSectorStart - o.mSectorStart;
            if (diff < 0)
            {
                return -1;
            }
            else if (diff > 0)
            {
                return 1;
            }
            else
            {
                return 1;
            }
        }
    }
    
    
    // Constructor
    public DVDelevator()
    {
        SetDefaults();
    }
    
    
    private void SetDefaults()
    {
        mElapsedMicroseconds = 0;
        mBatchEndMicrosecond = 0;
        mLaserPos = 1;
        
        mBatch = new ArrayList<ReadRequest>();
    }
    
    private void AdvanceTimeTo(long time)
    {
        mElapsedMicroseconds = time;
    }
    
    private void DispatchRequest(ReadRequest req)
    {
        // Add on the time it took to get the request if it is in the future
        if (req.mStartTimeMicroseconds > mElapsedMicroseconds)
            AdvanceTimeTo(req.mStartTimeMicroseconds);
        
        // Move laser to beginning
        mElapsedMicroseconds += Math.abs(req.mSectorStart - mLaserPos);
        mLaserPos = req.mSectorStart;
        
        // Print the request
        System.out.printf("Time %d: %d to %d\n", mElapsedMicroseconds, req.mSectorStart, req.mSectorEnd);
        
        // Move the laser to the end but don't count the time
        mElapsedMicroseconds += Math.abs(req.mSectorEnd - mLaserPos);
        mLaserPos = req.mSectorEnd;
    }
    
    private void DispatchBatch()
    {
        // Sort the list
        ReadRequest[] reqs = new ReadRequest[mBatch.size()];
        mBatch.toArray(reqs);
        Arrays.sort(reqs);
        
        // Dispatch them in order (all at the same time)
        for (int i = 0; i < reqs.length; ++i)
        {
            ReadRequest req = reqs[i];
            req.mStartTimeMicroseconds = mBatchEndMicrosecond;;
            DispatchRequest(req);
        }
        
        // Empty the batch list
        mBatch.clear();
    }
    
    private ReadRequest ParseStringAsReadRequest(String str)
    {
        String[] strArr = str.split(" ");
        
        ReadRequest req = new ReadRequest();
        req.mStartTimeMicroseconds = Long.parseLong(strArr[0]);
        req.mSectorStart = Long.parseLong(strArr[1]);
        req.mSectorEnd = Long.parseLong(strArr[2]);
        
        return req;
    }
    
    public void RunAlgorithm() throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("dvdelevator.dat"));
        
        boolean bFirst = true;
        String strLine = "";
        while (kb.hasNextLine())
        {
            strLine = kb.nextLine();
            
            ReadRequest req = ParseStringAsReadRequest(strLine);
            
            // If there is no batch in progress
            if (bFirst)
            {
                // Start first batch
                mBatchEndMicrosecond = req.mStartTimeMicroseconds + MICROSECONDS_PER_BATCH;
                mBatch.add(req);
                
                bFirst = false;
            }
            else
            {
                // Is our request inside the batch or outside?
                if (mBatchEndMicrosecond >= req.mStartTimeMicroseconds)
                {
                    mBatch.add(req);
                }
                else
                {
                    // If the request is over the time, we send off the previous batch
                    DispatchBatch();
                    
                    // If the next read is after the batch end then we can
                    // dispatch it right away
                    if (req.mSectorStart >= mLaserPos)
                    {
                        DispatchRequest(req);
                    }
                    else
                    {
                        // It isn't so we start a new batch
                        mBatchEndMicrosecond = Math.max(mElapsedMicroseconds, req.mStartTimeMicroseconds) + MICROSECONDS_PER_BATCH;
                        mBatch.add(req);
                    }
                }
                
            }
        }
        
        // Run the batch in case it isn't empty
        DispatchBatch();
    }

    
    public static void main(String args[]) throws IOException
    {
        // Easier to do the work with member variables, so just create an object
        // of the class and call into it
        DVDelevator elevator = new DVDelevator();
        elevator.RunAlgorithm();
    }
}
