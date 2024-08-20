# Discord Gekko Bot

*~Working Design Doc for Gekko Bot*
*Requirements, implementation ideas, problems to solve, dev diary etc...*

### Quick summary
Building a org.bot flavored as Gekko; The org.bot can get information from Val servers about players, stats etc.

### Desired features and requirements: 
I want users to be able to:
1. find recent match stats
2. Compile a collection of lifetime stats
3. Use collection to find overall stats (headshot %, k/d/a, best maps, % up or down)
4. Display rank

### Ideas for implementation

**Slash Commands** on the discord org.bot will call the org.bot to retrieve info.
The org.bot will compute the data that it needs to either with information it has received from the api but it will check its local cache and database first.
Using mySQL i can store blob info on users based on their riot id and discord id.
Within this database will exist previously computed and compiled values so there is no need to do it over again. 
The org.bot will only update these values with recent stats when update is called. (This may need to be refined)

### Tech stack (wip)

Java, maven, Spring boot, lombok
Research: Mysql, dynamoDb, aws server.
If i have other components i can use docker on my server to spin those up fast.

### Libraries and apis so far
1. JDA java discord api, wrapper for a discord org.bot.
2. Easy Commands library, supposed to make commands for discord org.bot easier to use. 
3. Henrik dev api, supposed to be used to get info from val servers. *Written in js or something, might have to write some javascrip not sure*. 

*Need to design system, components, find what components are needed*

## CURRENT TRELLO BOARD

### To Do

- [ ] Create exception handling for GET requests
- [ ] Test player data serialization
- [ ] Test match data serialization
- [ ] Create Slash Command for Player Data
- [ ] Create Slash Command for Match Data
- [ ] Write Service logic that uses match data
- [ ] Write Service logic that uses player data
- [ ] mock up diagrams
- [ ] Setup MySQL Database
- [ ] Get RSO token for Riot's api
- [ ] Write test REST calls to Riot's api
- [ ] Create a server to host the discord bot
- [ ] Get docker running
- [ ] Put the service components within their own docker containers
- [ ] Setup a noSql database
- [ ] Use NoSql to reduce api calls, and queries to DB
- [ ] see if automated tests are viable

### In Progress

- [ ] Create GET request for match data

### Done

- [x] Create GET request for player data
- [x] Create a design doc
- [x] Add bot to a discord server for testing
- [x] Create a github
- [x] Write test REST calls to henrik's valorant api
- [x] Build some example commands
- [x] add spring boot dependencies to the project
- [x] Create Dev Diary
- [x] Create a Trello Board

### Get Help

- [ ] nothing yet

## Dev Diary
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

<br>https://projectlombok.org/features/GetterSetter
<br>https://projectlombok.org/features/constructor
<br>https://hub.docker.com/_/openjdk/
<br>https://medium.com/@tiokachiu/java-based-apis-with-openapi-specifications-a-comprehensive-guide-b7ef8b649776
<br>https://www.baeldung.com/jackson-object-mapper-tutorial
<br>https://www.baeldung.com/java-dto-pattern

### Update 8/14/2024

I built out the rest of the objects needed for the match data request.

Shout Out Jacob AKA Jacoby & Meyers AKA ThirstyJGerzty for the lombok plugin.
It significantly cut down the horrible boiler plate getters and setters.
Unfortunately i've been thinking about doing a builder pattern for these objects.
Though I don't know if that makes any sense at all, and for some reason i'm just blaming spring boot for what a mess
this looks like.
Goddamn springboot.

### Update 8/14/2024 10 mins later

No. Fucking. Way. Bro.
Lombok has a fuckin builder annotation. I still don't know if i need this thing but it's fucking awesome to have one on
hand.
This is sick.

### Update 8/19

Created a trello board and an easy way to convert it to markdown, hell yeah
Hoping this helps with not getting overwhelmed

Creating the getrequest for match ended up working differently than i thought. I could not in fact deserialize into an
abstract class.
Honestly not sure why i thought I could. The whole idea of an abstract class was to handle error handling, but I ran
into
a different issue **again**. The response classes extending the abstract classes don't line up.
MatchResponse gets a list of data. While player response gets a single object.
This is frustrating on a couple levels. I want to be able to catch the exception of an incorrectly deserialized object
but
still get the error object. I thought if i made the error and normal responses extend the same abstract i could get away
with this but nope.
This is also frustrating because I really wanted this code to scale well and make it easy to implement new responses to
the api.
Gonna update the trello board and see if i can get some help i guess.
Good news is the request I made to getMatches actually worked after banging my head. Gotta double check your URL
endpoints Tony.
Also write some more comments dude. That way when we come back we're not totally befuddled by this libraries. 
