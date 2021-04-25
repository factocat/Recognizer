# Recognizer

### The Generic Application that can be used as a microservice to provide authentication mechanism
<hr>

The Objective of this application is to act as an authentication provider for any starter projects. 

This should function as a standalone microservice and should be capable to provide the authentication based on the following protocols:
 * [Basic Auth](https://en.wikipedia.org/wiki/Basic_access_authentication)
 * [OAuth 2.0](https://oauth.net/2/)

The clients are expected to use the [JWT](https://jwt.io/) based verification of the authentication based on a shared secret.

This websocket works on the following stack :
  * Java for Backend
  * Netty Server
  * MongoDB
  * Spring Boot with Spring Security
