# 기능 구현 사항 


### 코치(Coach)
-[ ] 필드로 이름을 가지고 있다.
-[ ] 이름의 제한은 2이상 4이하로 validate
-[ ] 각 코치는 최소 0개 최대 2개까지 못먹는 메뉴가 있다고한다..! , 로 구분해서 입력받아. 

### 코치들(Coaches)
-[ ] 일단 List<Coach> 로 생각하고 있다.
-[ ] 최소 2명에서 최대 5명으로 validate


### InputHandler
-[ ] 코치의 이름을 입력 받는다 (토미,제임스,포코)
-[ ] 각 코치가 못먹는 메뉴를 입력 받는다 (우동,스시)

---
# 내용 정리
- 월화수목금 점심 식사를 같이한다.
- 요일 -> 각 코치가 그 요일에 먹을 메뉴 추천. (반복)

- 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다. (,) 로 구분
- 먹지 못하는 메뉴가 없으면 빈 값을 입력한다.
- 추천을 못하는 경우는 발생하지 않으니 고려하지 않아도 된다.
- 각 코치에게는 중복되지 않은 메뉴를 추천해야 한다.(메뉴는 절때 겹치면 안돼요!)
- 각 코치가 못먹는 메뉴를 물어봐주야 한다!.
- 랜덤 추천은 pickNumberInRange() 를 쓴다고 한다.
- Randoms.pickNumberInRange()의 결과가 
- 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식을 추천해야 한다.
- 추천할 수 없다면 다시해야함!... 


- 메뉴는 Randoms.shuffle을 이용해서 섞은후 첫번째 값을 사용하세요.
- 카테고리에 포함되는 메뉴는 List<String> 형태로 준비하라구요..?
- 메뉴 역시 추천할 수 없는 메뉴 먹지 못하는 메뉴라면 다시 섞어야한다.

### 카테고리 
- 한주에 같은 카테고리는 2개까지만...!

"""
일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
"""

