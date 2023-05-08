@echo off

:: GLOBAL VARIABLES

SET CDROMDIR=InstalledFiles
SET BASEDIR=C:\UILProgramming
SET SENTINEL=%BASEDIR%\INSTDONE

SET STATUSLINE=

:: MAIN MENU
::
:mainmenu
TITLE UIL Hands-On CD Main Menu
CLS
ECHO   ============================================================================
ECHO                          UIL Programming CD - Main Menu
ECHO   ============================================================================
TYPE blankline
ECHO         1. View README
IF EXIST "%SENTINEL%" (
   ECHO         2. Install judge environment    [DONE - %BASEDIR%]
) ELSE (
   ECHO         2. Install judge environment    [TODO]
)
ECHO         3. Run judging script
ECHO         4. Quit
TYPE blankline
IF DEFINED STATUSLINE ECHO %STATUSLINE%
SET STATUSLINE=
SET /P MENUCHOICE="Please choose an option: "
IF %MENUCHOICE%==1 GOTO :viewreadme
IF %MENUCHOICE%==2 GOTO :installmaterials
IF %MENUCHOICE%==3 GOTO :judge
IF %MENUCHOICE%==4 EXIT /B
SET STATUSLINE=Invalid Choice, please try again.
GOTO mainmenu

:: OPTION - README.txt
:viewreadme
MORE README.txt
PAUSE
GOTO mainmenu

:: OPTION - MATERIALS
:installmaterials
MKDIR %BASEDIR%
XCOPY /I /Y /E %CDROMDIR%\* %BASEDIR%
IF ERRORLEVEL 1 (
   TYPE blankline
   ECHO Error copying judge environment
   ECHO Terminating...
   TYPE blankline
   PAUSE
   GOTO mainmenu
)
ECHO DONE > %SENTINEL%
IF ERRORLEVEL 1 (
   TYPE blankline
   ECHO Error copying judge environment
   ECHO Terminating...
   TYPE blankline
   PAUSE
   GOTO mainmenu
)
ECHO Installation complete.
ECHO Judge submissions using the commands:
ECHO      cd %BASEDIR%
ECHO      judge [problem]
ECHO where [problem] is the short name used by the problem's .java file.
PAUSE
GOTO mainmenu

:: OPTION - JUDGE
:judge
IF NOT EXIST "%SENTINEL%" (
   TYPE blankline
   ECHO ERROR: Judge environment not installed.
   ECHO Please install the judge environment before judging.
   TYPE blankline
   PAUSE
   GOTO mainmenu
)
PUSHD %BASEDIR%
SET /P PROBNAME="Please enter the problem's short name:"
START judge %PROBNAME%
POPD
GOTO mainmenu
