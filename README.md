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
- [x] add spring boot dependencies to the project
- [x] Write some test REST calls to henrik's valorant api
- [ ] I should find a way to have some automated tests for this thing if possible
- [ ] I should mock up some diagrams to make sure I understand how these components interact with eachother
- [ ] I might need a Database to track info, percentages, etc.
- [ ] a noSql database would be useful to reduce api calls, and calls to DB
- [ ] I need a server to host the discord org.bot so it’s not reliant on my computer

### Update 7/15/2024

Hey Cutie check this.
There are 2 pathways forward, Henriks api or Riot's api
There are a lack of personal account info endpoints with Henrik's api
this is because he is likely just a middleman between myself and riot, and probably is serving up his own auth token for
riot
but the info returned is clearly and cleanly formatted in json
His server seems to go down a lot

Alt is using RSO and using refresh tokens with Riot's api myself.
that would mean i have to cache and handle processing of each token to each user
but it would give me access to more personal account info, such as store info etc
The other part of this is the data i get back would be not as clean as Henrik's endpoints which is a bummer
Plan right now is to make two branches off master and try these out. Let's go.

### Update 8/11/2024

Ran into a problem with response data.
We ended up having many pojos to deserialize and were trying to minimize the amount by using polymorphism/inheritance.
So, in a response object we can either get the data that we expect or an error list.
The attempt to make a generic response object did not work.
Jacob suggests creating an abstract class. The class would consist of the status and error list.
Then, implementers would need to override the getData function to whatever data it expects.

Seemingly, if i have a property that i do not need to serialize I do not need to create that class or property for the
whole serialization to work.
SpringBoot seems a little unnecessary, but for now it's working as a deserializer and something to make api requests
with.
The SECOND this thing stops being useful or causes a problem, we're using Jackson to de/serialize and something else to
make api calls.
Consider importing libraries that make building classes easier with annotations instead of making a million getters and
setters.
Side note tangent: Using docker to make containers to add environment variables or specific configurations of mySQL java
etc
is a good idea. This is also a solution to scaling, if anything else ever needs to be added.

https://projectlombok.org/features/GetterSetter
https://projectlombok.org/features/constructor
https://hub.docker.com/_/openjdk/
https://medium.com/@tiokachiu/java-based-apis-with-openapi-specifications-a-comprehensive-guide-b7ef8b649776
https://www.baeldung.com/jackson-object-mapper-tutorial
https://www.baeldung.com/java-dto-pattern

### Update 8/14/2024

I built out the rest of the objects needed for the match data request.

Shout Out Jacob AKA Jacoby & Meyers AKA ThirstyJGerzty for the lombok plugin.
It significantly cut down the horrible boiler plate getters and setters.
Unfortunately i've been thinking about doing a builder patter for these objects.
Though I don't know if that makes any sense at all, and for some reason i'm just blaming spring boot for what a mess
this looks like.
Goddamn springboot.

### Update 8/14/2024 10 mins later

No. Fucking. Way. Bro.
Lombok has a fuckin builder annotation. I still don't know if i need this thing but it's fucking awesome to have one on
hand.
This is sick.