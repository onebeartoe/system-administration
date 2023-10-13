
# place this at ~/.bashrc

### Beto bash rc

# don't put duplicate lines or lines starting with space in the history.
# See bash(1) for more options
HISTCONTROL=ignoreboth

# append to the history file, don't overwrite it
shopt -s histappend

# for setting history length see HISTSIZE and HISTFILESIZE in bash(1)
HISTSIZE=10000
HISTFILESIZE=20000

#-----------------------------------------

# user name and pwd in prompt

export PS1='\[\033[01;32m\][\u@\h\[\033[01;37m\] \w\[\033[01;32m\]]\n$\[\033[00m\] '

#-----------------------------------------


# some more ls aliases
alias ll='ls -alhF'


#-----------------------------------------



export JAVA8_HOME=/opt/jdk/oracle-jdk1.8.0_261
export JAVA11_HOME=/opt/jdk/oracle-jdk-11
export JAVA12_HOME=/opt/jdk/oracle-jdk-12
export JAVA16_HOME=/opt/jdk/adoptium/jdk-16.0.2+7
export JAVA21_HOME=/opt/java/openjdk-21
export JAVA_HOME=$JAVA21_HOME
alias java8='export JAVA_HOME=$JAVA8_HOME; PATH=$JAVA_HOME/bin:$PATH'
alias java11='export JAVA_HOME=$JAVA11_HOME; PATH=$JAVA_HOME/bin:$PATH'
alias java12='export JAVA_HOME=$JAVA12_HOME; PATH=$JAVA_HOME/bin:$PATH'
alias java16='export JAVA_HOME=$JAVA16_HOME; PATH=$JAVA_HOME/bin:$PATH'
alias java21='export JAVA_HOME=$JAVA21_HOME; PATH=$JAVA_HOME/bin:$PATH'

export M2_HOME=/opt/maven/apache-maven-3.9.4
export M2=$M2_HOME/bin
export MAVEN_OPTS="-Xms256m -Xmx512m"
export PATH=$JAVA_HOME/bin:$PATH:$M2

