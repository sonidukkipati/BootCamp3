#!/bin/bash

# mappings for Ctrl-left-arrow and Ctrl-right-arrow for word moving
bindkey '^[^[[C' forward-word
bindkey '^[^[[D' backward-word

ZDOTDIR=$_OLD_ZDOTDIR

if [ -n "$JEDITERM_USER_RCFILE" ]
then
  source $JEDITERM_USER_RCFILE
  unset JEDITERM_USER_RCFILE
fi

if [ -f "$HOME/.zshrc" ]; then
     source "$HOME/.zshrc"
fi

if [ -n "$JEDITERM_SOURCE" ]
then
  source $JEDITERM_SOURCE
  unset JEDITERM_SOURCE
fi