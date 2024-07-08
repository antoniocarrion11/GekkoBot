# Discord Gekko Bot

*~Working Design Doc for Gekko Bot*
*Requirements, implementation ideas, problems to solve etc...*

### Quick summary
Building a org.bot flavored as Gekko; The org.bot can get information from Val servers about players, stats etc.

### Desired features and requirements: 
I want users to be able to:
1. find recent match stats
2. Copile a collection of lifetime stats
3. Use collection to find overall stats (headshot %, k/d/a, best maps, % up or down)
4. Display rank

### Ideas for implementation

**Slash Commands** on the discord org.bot will call the org.bot to retrieve info.
The org.bot will compute the data that it needs to either with information it has received from the api but it will check its local cache and database first.
Using mySQL i can store blob info on users based on their riot id and discord id.
Within this database will exist previously computed and compiled values so there is no need to do it over again. 
The org.bot will only update these values with recent stats when update is called. (This may need to be refined)

### Tech stack (wip)
Java, maven, javascript maybe? 
Research: Spring boot, Mysql, dynamoDb, aws server.
If i have other components i can use docker on my server to spin those up fast.

### Libraries and apis so far
1. JDA java discord api, wrapper for a discord org.bot.
2. Easy Commands library, supposed to make commands for discord org.bot easier to use. 
3. Henrik dev api, supposed to be used to get info from val servers. *Written in js or something, might have to write some javascrip not sure*. 

*Need to design system, components, find what components are needed* 
- [x] Create a github repo and design doc
- [x] I should build some example commands to get some bare bones before building it all up
- [x] Gotta add the org.bot to a discord server for testing the commands
- [ ] Write some test spring boot api calls to henrik's valorant api
- [ ] I should find a way to have some automated tests for this thing if possible
- [ ] I should mock up some diagrams to make sure I understand how these components interact with eachother
- [ ] I know i need something like Spring Boot for my rest endpoints to valorant api
- [ ] I might need a Database to track info, percentages, etc.
- [ ] a noSql database would be useful to reduce api calls, and calls to DB
- [ ] I need a server to host the discord org.bot so it’s not reliant on my computer