# Pokemon Team Building Tools
Tools for calculating EV Spreads and Flow Charts.  
The intial aim is to help players see how a PokePaste handles the Meta.  
This will be acomplished by creating a way to convert PokePastes into POJOs and use Showdown/Pikalytics to get the speads and items for the damage calculator to use. Create a Selenium & PhantomJS layer over the Damage Calc Page to programatically set the values and receieve the results.  
With this setup, we can then provide recommendations on matchups and help Flow Chart some matchups.  
After that we can start to do EV Spread optimisations, incase EVs are being wasted in Attacks or Defense. For example, if a EV Spread doesn't turn a 2-Hit KO into a 3-Hit KO for any relevant attack, then those defensive EVs are being wasted. Or can we 2-Hit KO without a Berry proc.

## Project Status

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/lukegjpotter/pokemon-team-building-tools/blob/master/)
[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/9699a21ad146ad431f8f)  
[![Maintainability](https://api.codeclimate.com/v1/badges/8bcc99b2fa15519f0655/maintainability)](https://codeclimate.com/github/lukegjpotter/pokemon-team-building-tools/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/8bcc99b2fa15519f0655/test_coverage)](https://codeclimate.com/github/lukegjpotter/pokemon-team-building-tools/test_coverage)
[![Build Status](https://travis-ci.com/lukegjpotter/pokemon-team-building-tools.svg?branch=master)](https://travis-ci.com/lukegjpotter/pokemon-team-building-tools)

## Project Setup

If you want to use/develop for this you can setup your local environment with the instructions on
the [wiki's Project Setup](https://github.com/lukegjpotter/pokemon-team-building-tools/wiki/Project-Setup) Page.

## Run Project

Start the Server in one Terminal with:

    ./gradlew build bootRun

Then open a second Terminal and try:

    curl -X GET localhost:8080/pokepaste/test
    curl -X GET localhost:8080/pokepaste/url -d "https://pokepast.es/7773fa9f6619a549" -H "Content-Type: text/plain"

Alternatively try Postman, or other GUI tool.  
The response should be along the lines of:

    {"id":0,"team":[]}

Swagger UI REST documentation is available on:

    http://localhost:8080/swagger-ui/index.html

Then use `ctrl + C` to stop the Server.