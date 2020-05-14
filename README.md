# Coding test 2020
**Design considerations**<br/>
- As intention of announcing my pet project on twitter, hackernews or reddit. 
I need to build a system that allow I post a message to twitter, hackernews or reddit based on my configure.
And in the future, if I have other project(for example Car project) and I want to use this system to announce my new project then I can configurable to announce my new project. So that, I can use IoC to control my system.
- In my system, each project class( Pet, Card project...) will have some services(helpers) to help them and these services can be configurable and won't change implementation of my class. So that, We can use DI to inject services to my class
<br/>

![](design.png)

<br/>

**Limitation**<br/>
- Currently, we can only post a message on one social network at time. If we want to post a message to other social network, we need to configure to inject(DI) other service to project.<br/>
- I just implement PostMessage for TwitterMessageService. Other MessageService are not finished
<br/>
<br/>

**User Guide**<br/>
- Go to application.properties and update your keys to able to can API from Twitter, Hackernews, Reddit<br/>
![](key.png)
<br/>

- Currently, default project that I want to announce is Pet project. If you want to announce other project(such as Car project). You need to do:<br/>
    + Remove @Component("projectActivity") in PetProjectActivity class<br/>
    + Add @Component("projectActivity") to CardProjectActivity class<br/><br/>
- Default social network that I post a message is Twitter. If you want to use other social network(such as Reddit..). You need to do:<br/>
    + Remove @Component in TwitterMessageService class<br/>
    + Add @Component to RedditMessageService<br/><br/>
- Go to ApplicationDemo class, update MESSAGE and run to post a message to social network    <br/>

![](result.png)

<br/>

Run Test
If you want to run test. Just open project folder and run mvn clean install

![](mvn_install.png)


