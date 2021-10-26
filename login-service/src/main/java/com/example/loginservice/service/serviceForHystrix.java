@Service
public class ServiceForHystrix {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "call"SomeService"AndGetData_Fallback")
    public String call"SomeService"AndGetData(String xxx) {

        System.out.println("Getting details for " + xxx);

        String response = restTemplate
                .exchange("http://localhost:8098/get"path""
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, xxx).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! -  -  " + xxx + " :::  " +
                " Details " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    private String call"SomeService"AndGetData_Fallback(String xxx) {

        System.out.println(" Service is down!!! fallback route enabled...");

        return "CIRCUIT BREAKER ENABLED!!! No Response From  Service at this moment. " +
                " Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}