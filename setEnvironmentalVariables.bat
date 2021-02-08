@ECHO OFF
ECHO [info] Setting DATABASE_URL
@SET DATABASE_URL=postgres://postgres:postgres@localhost:5432/pokemonteams
ECHO [info] Set DATABASE_URL to %DATABASE_URL%