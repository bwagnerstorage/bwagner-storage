  ============================================================================
                                UIL Programming README
  ============================================================================

  THE MAIN MENU

    The UIL Hands-On CD provides the following choices on the Main Menu:

      1. View README
      2. Install judge environment
      3. Run the judging script
      4. Quit

    Option 1 - View README

      Displays this file (README.txt)

    Option 2 - Install judge environment

      Copies all files necessary to judge the contest to the computer's hard
      drive.  This step must be completed prior to judging.

    Option 3 - Run the judging script

      Executes the judging script from the CD-ROM.  This should be done when
      a submission has arrived and needs to be judged.

      This option exists as a convenience for installation where every judge
      machine has its own copy of the UIL CD-ROM.  Since this is not normally
      the case, a copy of the judging script is copied to the hard drive by
      Option 4 (C:\UILJudge\judge.bat).  It is expected that most sites will
      run the judging script directly from the hard drive instead of making
      use of Option 3 from the CD-ROM.

      When running from the hard drive, judge submissions using the commands:

        cd C:\UILProgramming
        judge [problem]

      where [problem] is the short name used by the problem's .java file.

      For hints and tips on judging, see 'THE JUDGING SCRIPT' below.

    Option 4 - Quit

      Exits the UIL Hands-On CD menus.  You can get back to these menus by
      either removing and reinserting the CD-ROM or by running the install.bat
      file on the CD-ROM.

  THE JUDGING SCRIPT

    Please check the judge.bat file in C:\UILProgramming and adjust the FLOPPY 
    variable if needed. The judge.bat file contains an explanation of how to 
    set this value.

    When run, the judging script performs the following basic actions:

      1. Archives the constestant program
      2. Copies the contestant program to a clean directory
      3. Compiles the contestant program
      4. Executes the contestant program
      5. Compares the contestant program output to the expected output

    During the 5th step, the Windows program CSDiff is invoked to compare
    the output from the contestant program to the expected output.  In the
    best case, CSDiff will display a dialog box with the message:

        "Revisions are identical or differ by white space only!"

    This means that the output was correct and that no inspection is 
    required by a judge.

    If there are disparities between actual and expected output, CSDiff will
    instead display a window which highlights the differences between the
    output produced by the contestant program and the expected output.  This
    display can be confusing, so I urge all judges to experiment with the
    interface during the dry run.

    The judge will have to make the final determination for the submission.
    Here are the basic guidelines for judges:

      1. Whitespace differences at the ends lines or after the last line
         of output are never significant.

      2. If the differences do not seem material to the problem solved,
         err on the side of accepting the solution.  For instance, if a
         problem is about performing complex calculations, be flexible
         with output formatting.  On the other hand, if the problem is
         all about formatting, then be a stickler.

      3. Above all, be consistent in your judging.  With this goal in mind,
         it is usually best for each problem to have a designated judge or
         judging team to help ensure judging consistency for that problem.
