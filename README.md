#  Spring Boot's @MockBean Annotation

####  We can use the @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
   
#### If no bean of the same type is defined, a new one will be added. This annotation is useful in integration tests where a particular bean – for example, an external service – needs to be mocked.


## Mock Concepts and Definition

```$xslt
    
Dummy objects are passed around but never actually used. Usually, they are just used to fill parameter lists.
    
Fake objects have working implementations, but usually, take some shortcut which makes them not suitable for production (an in memory database is a good example).
    
Stubs provide canned answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test. Stubs may also record information about calls, such as an email gateway stub that remembers the messages it ‘sent', or maybe only how many messages it ‘sent'.
    
Mocks are what we are talking about here: objects pre-programmed with expectations which form a specification of the calls they are expected to receive.    

``` 