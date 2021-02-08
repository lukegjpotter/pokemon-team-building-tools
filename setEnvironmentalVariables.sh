#!/usr/bin/env bash

# Test Colours
red=`tput setaf 1`
green=`tput setaf 2`
reset=`tput sgr0`

# Ensure that file is being sourced, as ./ won't set the Env Variables outside this script's context.
if [ "$0" = "./setEnvironmentalVariables.sh" ]
then
  echo " ${red}[error]  Usage of this file should be 'source setEnvironmentalVariables.sh'${reset}"
  exit 1
fi

# Set Database URL for local testing
echo " [info] Setting DATABASE_URL"
export DATABASE_URL='postgres://postgres:@localhost:5432/pokemonteams'
echo " ${green}[info] Set DATABASE_URL to $DATABASE_URL ${reset}"
