# Spring_mvc_drill

## Servlet 을 통한 request, response

### request 3가지 방식
 * HTML-form
 * request parameter
 * HTTP API

## Servlet, JSP의 MVC 패턴 적용
  * v1: FrontController 객체를 통한 servlet 요청 컨트롤, Controller 분리
  * v2: MyView 객체를 이용한 view 처리 -> MyView 객체의 render()를 통해서 모든 Controller에서 view를 일관되게 처리
  * v3: 
      * servlet(request, response)를 종속성 제거 -> ModelView 객체를 통해 데이터를 전달
      * 반복적인 view 이름 제거 -> 논리 이름만 사용
      * controller 로직의 단순화 -> FrontController의 처리가 늘어남
