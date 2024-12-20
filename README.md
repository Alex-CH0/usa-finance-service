# usa-finance-service

Project-USA 중 API 연동을 통한 종목 및 시세 정보 업데이트, 저장을 맡고 있는 Micro Service. 

## 주요 기능
- Spring Open Feign 기능을 통한 빗썸 API연동, 코인 정보 조회
- Spring Schedule 기능을 통한 시세 정보 DB 저장 및 업데이트

### Feign client

Feign Client는 Http Client로 Spring 에서 어노테이션을 통한 간편한 Http 요청 가능.
기존 RestTemplate 보다 편하고, JPA와 같이 인터페이스와 구현체를 통해 표현되므로 
익숙함에서 오는 편의성이 존재. 

