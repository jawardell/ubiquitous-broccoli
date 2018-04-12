# Skewed Top Corridor Number Generator

Skewed top corridor numbers lie within a 
structure called a skewed-top corridor. 
The sequences that have been spotted in these 
corridors don't seem to have been documented yet and 
there is currently not a closed-form formula for 
skewed top corridor numbers. 
The study of STCs falls within the realm of 
enumerative combinatorics and lattice path counting. 
These corridors are simply complicated and this study is 
an ongoing work. I presented some of the progress on 
STCs at an undergraduate research conference at my 
school. For more information about STCs, check out the 
media directory.

<br>
<img src="/media/latex/imgs/seq.png"/>
<br>

I wrote a program to generate STC numbers 
in a basic command line interface style. If you would 
like to start studying STCs, use this program by following 
the steps below. Please note that you will need to adjust the 
font size in your command line for proper results. 

You'll nee to have the <a href="https://java.com/en/">Java Runtime Environment</a> and the 
<a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">Java Development Kit</a> installed and added to the PATH environment variable. 

### How to use
First, clone this repository by issuing the following command...

`git clone https://github.com/jawardell/ubiquitous-broccoli`


...then move into the directory: 

`cd ubiquitous-broccoli`

To generate STCs on a Unix terminal, 
execute the config script by issuing the 
following command: 

`./config.sh`

To generate STCs in a batch command prompt, 
issue the following commands: 

`javac src\slopeTester.java`<br>
`java src\slopeTester`


Check out the programs that I wrote to generate 
the numbers. You can adjust the parameters to 
modify the numbers inside the corridors. 
Change the parameters and find new patterns within 
the corridors!

