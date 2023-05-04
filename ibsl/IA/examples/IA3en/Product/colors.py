import random
border = { }  # dictionary containing { region0 : [neighbor1, neighbor2, ...]
              #                         region1 : [neighbor1, neighbor2, ...]
              #                       }
state = { }   # dictionary containing { region0 : 0,  region1 : 1 , ...}
max = 0       # number of regions in the map
co = [ ]      # array of random color assignment for each region in state list

colors = ("red","green","blue","yellow")  # fixed names of 4 colors
tries = 1000           # limited number of tries in each search
mapname = "CANADA"     # name of file containing borders data

def randomColors(choices):    # choose a random color for each region
    for n in range(0,max):
        c = random.randint(0,choices-1)  # random number
        co[n] = colors[c]                # store random color in colors list

def listColors():             # print list of regions and colors
    for s in state:
        print s , " = " , co[state[s]]

def checkColors():  # check all pairs of regions and neighbors for same color
    okay = True                    # result (success so far)
    for x in border:               # each region in border dictionary
        for c in border[x]:        #   each in neighbors list
            a = state[x]           # get color of x
            b = state[c]           # get color of c
            if co[a] == co[b]:     # if colors match, then success = false
                okay = False
    return okay                    # return success or failure

def readborders():    # read data from text-file and store in border dictionary
    count = 0                        # counting regions
    infile = open(mapname,'rU')         
    print "=== Map = ",mapname," ==="   
    while(1):                        # loop through entire file
        indata = infile.readline()   # read data:  region,neighbor,neighbor...
        num = len(indata)                    
        if indata[num-1:num]=='\n':  # need to remove 
            indata = indata[0:num-1]            
        if len(indata)<1:            # stop at end of file
            break        
        items = indata.split(",")    # change String to array
        num = len(items)            
        border[items[0]] = items[1:num]         # add data to border dictionary
        print items[0] , " : " , border[items[0]]    # region : [neighbors]
        state[items[0]] = count                      # index of this region
        co.append("")                # makes co an array of matching lenght
        count = count + 1
    infile.close()
    print "=================="
    return count                     # number of regions

def go(choices):    # main loop - tries a set of random colors, then another
                    # repeating until success or quitting after 1000 tries
    global border, state, co, max, tries
    border = { }
    state = { }
    co = [ ]
    max = readborders()       # load data from file

    done=False                # not yet successful
    for t in range(0,tries):  # try 1000 times
        if done == False:              # if still unsuccssful then
            randomColors(choices)      # choose colors
            if checkColors() == True:  # check whether successful
                listColors()           # if successful then print colors 
                done = True
                return done            # quit early if successful
            
    if done==False:
        print "did not find a solution in ", tries, " tries"

    return done                        # return success or failure

def start():          # main logic - try 4 colors, then 3 if
                      #               it was successful
    global mapname
    
    mapname = raw_input("Map name (e.g. CANADA)?")
    result = False
    while(result == False):
        result = go(4)
        if result == True:
            result = False
            while(result == False):
                print "Trying with 3 colors"
                result = go(3)
                if result==False:
                    answer = raw_input("press Q to quit,[enter] to retry 3 colors")
                    if answer=="Q" or answer=="q":
                        result = True
        else:
            answer = raw_input("press Q to quit,[enter] to try 4 colors again")
            if answer == "Q" or answer == "q":
                return
        
start() 

raw_input("== Finished ==")   
