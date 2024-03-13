# spring-security-implement
This repository contains code to practice spring security fundamental 
We have contained some concept
Authentication = let application know who you are by entering UserName and Password
Authorization = Once user login Application determining ,what roles/access are assigned to the specific user
different ways of authentication
1) Basic Auth
2) FormBased Auth
3) OAuth(sso)
4) Customized Auth
Confidentialy - Application ensures the data you are sharing is not vulnerable to hackers (encoding -decoding )using https
Integrity - Application ensures data comes for the valid source and not modified in the process(Signatures helps in)

2 MORE IMPORTANT CONCEPT
1) CORS - Cross origin resource sharing(used when communication b/w different domain, browser not allow cors you have to enable it)
2) CSRF - Cross site request forgery(will prevent another website to submit data on our behalf)

-----------------------------------------------------------------------------------------------------------------------------------------
The key security components

Rest Client , Authentication Filter(class), Authentication Manager(interface), Authentication Provider(interface), User Details Service(interface), Password Encoder(interface), Security Context

rest sents a request to our rest client the very first component that intercept that request is Authentication filter(Servlet class), checks if user is authenticated if not then sent request to authentication manage that will check if credentials are valid (internally uses authentication provider where the login logic is defined,it doesn't feth detaials from db,ldap,inmemory db it'll use user details service and password encoder) then sent response back to the authentication filter
