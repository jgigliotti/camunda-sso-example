Simple example of using Github as an identity provider with Spring Security. Drawing from
[this example](https://github.com/camunda-consulting/code/tree/master/snippets/springboot-security-sso)
for inspiration.

To get started, go to [Github.com](https://github.com) and add a new `OAuth App` under Settings -> Developer Settings
-> OAuth Apps, extracting the generated `clientId` and `clientSecret` and placing them in `application.properties`. 

Note: this demo is hard coded in 
[CustomAuthenticationProvider](src/main/java/com/example/workflow/config/CustomAuthenticationProvider.java)
to persist the administrator `Demo` user, regardless of who you logged in as through the identity provider.
This is merely out of convenience for demo purposes.