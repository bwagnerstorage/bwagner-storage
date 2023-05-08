::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: judge.bat
::
:: This Windows batch file is intended to help automate the judging of
:: UIL hands-on programming contests.  It provides the following functions:
::
:: 1. Archival of submitted solutions
:: 2. Compilation and execution of solutions, 
::    displaying variances between expected/actual output
::
:: This batch file is invoked using the following syntax:
::
::    judge <problem>
::
:: Where <problem> is the short name of the problem and matches the names
:: of the problem's data files without the extension.  For example, if judging
:: a problem with an output data file named hardprob.out, the you would judge
:: it using the command:
::
::    judge hardprob
::
:: Please be sure to customize the settings in the VARIABLE DEFINITIONS section
:: before using this batch file or the results may be unpredictable.
::
:: Currently, the only variable in this section is FLOPPY.  This should be the
:: full path to the location where the contestant submissions will be.  Normally,
:: this is a folder at the top level of the C drive, but can be changed if needed.
::
:: Also, note that this batch file requires command extensions to be enabled.
:: Command extensions are enabled by default, so this is not likely to be
:: a problem.
@ECHO OFF

::
:: VARIABLE DEFINITIONS
::
SET FLOPPY=C:\UILSolutions

::
:: CONSTANT DEFINITIONS
::
SET BASEDIR=C:\UILProgramming
SET ARCHIVEDIR=%BASEDIR%\ArchiveDir
SET  MASTERDIR=%BASEDIR%\MasterDataDir
SET EXECUTEDIR=%BASEDIR%\ExecuteDir
SET  CLASSPATH=%BASEDIR%\jdk1.8.0_151\src.zip
SET      JAVAC=%BASEDIR%\jdk1.8.0_151\bin\javac.exe
SET       JAVA=%BASEDIR%\jdk1.8.0_151\bin\java.exe
SET   DIFFPROG=%BASEDIR%\CSDiff\CSDiff.exe
SET TEAMNAMEBASE=team
SET PROBLEM=%1

::
:: Main program starts here
::
@ECHO OFF
CLS
TITLE Judging problem -%PROBLEM%-

:: Check for validity of the VARIABLE DEFINITIONS
CALL :check
IF NOT %outcome%==VALID (
   ECHO Exiting due to errors...
   PAUSE
   GOTO :EOF
)

:: Get the team's ID from the judge
CALL :getid

:: Archive the team's submission, if it exists
CALL :archive

:: Run this team's submission
CALL :run

:: We're done
GOTO :EOF


::::::::::::::::::::::::::::::::::::::::::
:: check - Check for validity of settings
::
:check
SET outcome=VALID
IF "%PROBLEM%"=="" (
   SET outcome=INVALID
   ECHO ERROR: no problem defined.
   ECHO Please either set PROBLEM in the script or use an argument when running judge.bat
   ECHO Syntax: judge.bat [problem]
   ECHO Example for a problem with input file named example.dat: judge.bat example
   GOTO :EOF
)
IF NOT EXIST "%ARCHIVEDIR%" (
   SET outcome=INVALID
   ECHO ERROR: Archive directory %ARCHIVEDIR% does not exist.
   GOTO :EOF
)
IF NOT EXIST "%MASTERDIR%" (
   SET outcome=INVALID
   ECHO ERROR: Master directory %MASTERDIR% does not exist.
   GOTO :EOF
)
IF NOT EXIST "%MASTERDIR%\%PROBLEM%.dat" (
   SET outcome=INVALID
   ECHO ERROR: Could not locate master input file: %MASTERDIR%\%PROBLEM%.dat.
   GOTO :EOF
)
IF NOT EXIST "%MASTERDIR%\%PROBLEM%.out" (
   SET outcome=INVALID
   ECHO ERROR: Could not locate master output file: %MASTERDIR%\%PROBLEM%.out.
   GOTO :EOF
)
IF NOT EXIST "%EXECUTEDIR%" (
   SET outcome=INVALID
   ECHO ERROR: Execute directory %EXECUTEDIR% does not exist.
   GOTO :EOF
)
IF NOT EXIST "%JAVAC%" (
   SET outcome=INVALID
   ECHO ERROR: Java compiler %JAVAC% does not exist.
   GOTO :EOF
)
IF NOT EXIST "%JAVA%" (
   SET outcome=INVALID
   ECHO ERROR: Java interpreter %JAVA% does not exist.
   GOTO :EOF
)
IF NOT EXIST "%DIFFPROG%" (
   SET outcome=INVALID
   ECHO ERROR: Diff program %DIFFPROG% does not exist.
   GOTO :EOF
)
GOTO :EOF

::::::::::::::::::::::::::::::::::::::::::::
:: getid - Get the team's ID from the judge
::         Also changes the window title
::
:: outputs TEAMID
::
:getid
SET /P TEAMNUMBER="Please enter the team number (i.e., 12): "
IF "%TEAMNUMBER%"=="" GOTO :getid
SET TEAMID=%TEAMNAMEBASE%%TEAMNUMBER%
TITLE Judging -%PROBLEM%- for -%TEAMID%-
GOTO :EOF

:::::::::::::::::::::::::::::::::::::::::::::
:: archive - Archive's the team's submission
::
:: First, we'll check that the submission exists.
:: Then, we'll archive it to a directory tree that looks like this:
::
:: %ARCHIVEDIR%
::    -%PROBLEM%
::        -%TEAMID%
::            -%PROBLEM%.java.<TIMESTAMP>
:: 
:: Note that we don't include the date since we assume that you
:: won't be running a contest through midnight.
::
:archive

ECHO Please insert submitted floppy into drive...
PAUSE

IF NOT EXIST "%FLOPPY%\%PROBLEM%.java" (
   ECHO ERROR: Cannot find submission file %FLOPPY%\%PROBLEM%.java
   ECHO Judgement - COMPILE ERROR
   ECHO Terminating...
   GOTO cleanup
)
IF NOT EXIST "%ARCHIVEDIR%\%PROBLEM%\%TEAMID%" (
   MKDIR "%ARCHIVEDIR%\%PROBLEM%\%TEAMID%"
)
SET MYTIME=%TIME:~0,2%.%TIME:~3,2%.%TIME:~6%
COPY "%FLOPPY%\%PROBLEM%.java" "%ARCHIVEDIR%\%PROBLEM%\%TEAMID%\%PROBLEM%.java.%MYTIME%"
GOTO :EOF

:::::::::::::::::::::::::::::::::::::::::::::::::
:: run - Run's the submission and shows the diff
::
:run
PUSHD "%EXECUTEDIR%"

DEL /Q "%EXECUTEDIR%"

COPY "%FLOPPY%\%PROBLEM%.java" .
ECHO Remove the floppy from the drive...
PAUSE

ECHO Compiling program...
"%JAVAC%" -nowarn -classpath . %PROBLEM%.java
IF ERRORLEVEL 1 (
   ECHO Judgement - COMPILE ERROR
   ECHO Terminating...
   GOTO cleanup
)
PAUSE

ECHO Running program...
COPY "%MASTERDIR%\%PROBLEM%.dat" .
"%JAVA%" -classpath . %PROBLEM% > %PROBLEM%.out
IF ERRORLEVEL 1 (
   ECHO Judgement - RUNTIME ERROR
   ECHO Terminating...
   GOTO cleanup
)
PAUSE

ECHO Diffing output...
"%DIFFPROG%" /bD /sC %PROBLEM%.out "%MASTERDIR%\%PROBLEM%.out"

:cleanup
POPD
PAUSE
GOTO :EOF
