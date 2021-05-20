# spring-security-jpa
spring boot + spring security + jpa

By default when spring-security is added, it will ask for all request made to get authenticated. 
Default user is user and password is printed in console.

Unlike JDBC, there is no out of the box implementation for JPA authentication manager in spring security.
Instead what we do, we create our own implementation of UserDetailsService which uses JPA to fetch data from mysql database.

All authentication manager/builder calls loadUserByUsername method of UserDetails to fetch user's details.
We can extend UserDetailsService and create our own implementation.

1. Add dependency of jpa and mysql.
2. Set authorization using configure method.

UserDetails Setup
3. Create MyUserDetailsService and implement the method loadUserByUsername
4. Create MyUserDetails which will implement UserDetails
This is done basically to create our own objects which will deal with JPA.
   
5. Create User Entity and UserRepository which will be JPARepository and will fetch user from database.
6. User UserRepository in MyUserDetails to set values in MyUserDetails which will be returned to configure method as a result of authentication.

This is the process of authentication using JPA.

Table script is present in queries.sql file.

