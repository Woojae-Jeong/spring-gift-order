# spring-gift-enhanment
 
Step1
# 기능 요구 사항
상품 정보에 카테고리를 추가한다. 상품과 카테고리 모델 간의 관계를 고려하여 설계하고 구현한다.

-상품에는 항상 하나의 카테고리가 있어야 한다.
    상품 카테고리는 수정할 수 있다.
    관리자 화면에서 상품을 추가할 때 카테고리를 지정할 수 있다.
-카테고리는 1차 카테고리만 있으며 2차 카테고리는 고려하지 않는다.
-카테고리의 예시는 아래와 같다.
    교환권, 상품권, 뷰티, 패션, 식품, 리빙/도서, 레저/스포츠, 아티스트/캐릭터, 유아동/반려, 디지털/가전, 카카오프렌즈, 트렌드 선물, 백화점, ...

아래 예시와 같이 HTTP 메시지를 주고받도록 구현한다.

## Request
GET /api/categories HTTP/1.1

## Response
HTTP/1.1 200
Content-Type: application/json

[
{
"id": 91,
"name": "교환권",
"color": "#6c95d1",
"imageUrl": "https://gift-s.kakaocdn.net/dn/gift/images/m640/dimm_theme.png",
"description": ""
}
]

# 프로그래밍 요구 사항
구현한 기능에 대해 적절한 테스트 전략을 생각하고 작성한다.

# 구현할 기능 정리
1. 힌트를 바탕으로 category 엔티티 클래스 구현
2. 힌트를 바탕으로 product->category 단방향 맵핑 구현
3. categoryController, categoryService, categoryRepository 구현
4. 관리자 화면에서 상품을 추가할 때 카테고리를 지정할 수 있도록, 상품을 수정할 때 카테고리를 수정할 수 있도록 api 구현
5. categoryRepository에 대한 테스트 구현

-------------------------------------------------------------------------------------------------

step2

# 기능 요구 사항
상품 정보에 옵션을 추가한다. 상품과 옵션 모델 간의 관계를 고려하여 설계하고 구현한다.

상품에는 항상 하나 이상의 옵션이 있어야 한다.
옵션 이름은 공백을 포함하여 최대 50자까지 입력할 수 있다.
특수 문자
가능: ( ), [ ], +, -, &, /, _
그 외 특수 문자 사용 불가
옵션 수량은 최소 1개 이상 1억 개 미만이다.
중복된 옵션은 구매 시 고객에게 불편을 줄 수 있다. 동일한 상품 내의 옵션 이름은 중복될 수 없다.
(선택) 관리자 화면에서 옵션을 추가할 수 있다.
아래 예시와 같이 HTTP 메시지를 주고받도록 구현한다

Request
GET /api/products/1/options HTTP/1.1

Response
HTTP/1.1 200
Content-Type: application/json
[
{
"id": 464946561,
"name": "01. [Best] 시어버터 핸드 & 시어 스틱 립 밤",
"quantity": 969
}
]

# 프로그래밍 요구 사항
구현한 기능에 대해 적절한 테스트 전략을 생각하고 작성한다.

# 구현할 기능 정리
1. Option 엔티티 클래스 구현
2. 옵션 -> 상품 단방향 맵핑 구현 
3. Option Cotnroller, Service, Repository 구현
4. (선택) 관리자 화면에서 상품 추가 시 옵션을 1개 추가하게 끔 구현 
5. Option 도메인 객체 및 OptionController에 대한 테스트 구현

----------------------------------------------------------------------------------------------------

step3

# 기능 요구 사항
상품 옵션의 수량을 지정된 숫자만큼 빼는 기능을 구현한다.

별도의 HTTP API를 만들 필요는 없다.
서비스 클래스 또는 엔티티 클래스에서 기능을 구현하고 나중에 사용할 수 있도록 한다.

# 프로그래밍 요구 사항
구현한 기능에 대해 적절한 테스트 전략을 생각하고 작성한다.
단위 테스트하기 어려운 코드와 단위 테스트 가능한 코드를 분리해 단위 테스트 가능한 코드에 대해 단위 테스트를 구현한다.
