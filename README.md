# 점메추 구현 사항 목룍

-[ ] 추천할 카테고리를 무작위로 정하고 요일에 추천해준다.
-[ ] 이걸 주 5일 평일에 반복한다.
-[ ] 추천 못하는 경우는 고려 x
-[ ] 한 주에 같은 카테고리는 2번까지만 고를 수 있어
-[ ] 각 코치에게 중복되지 않는 메뉴를 추천한다.
-> 메뉴도 같으면 안되고 카테고리는 2번까지만 가능해! 
-[ ] 잘 못 입력시 [Error] 과 함께 뜨고 다시 입력 그 부분부터 


## 입력 
-[ ] 가장 처음 메뉴를 추천받을 코치의 이름을 입력받아.
-[ ] 각 코치를 말하면서 못먹는 음식을 입력받는다 ( , 기준이고 없다면 빈칸을 입력한다.)


## 출력 
-[ ] 출력 형식에 맞게 쭉 출력해주면 된다~


# 시작 해보자
### 코치
-[ ] 코치는 이름을 가지고 있으며 최소 2글자 최대 4글자다.
-[ ] 코치는 못먹는 음식을 최소 0개 최대 2개까지 가지고 있다. -> 이게 메뉴판에 잇는지 검사해야함.

### 코치들
-[ ] 코치들은 최소 2 최대 5개까지 길이를 가질 수 있따.

### 카테고리와 메뉴 
-[ ] String enum으로 들고 있는 것으로 한다.
-[ ] 번호를 들고 있고 String으로 나머지 메뉴들을 가지고 있다. 생성자에서 list 넣도록 처리.
--> 이 부분 부터 해보자.

### 랜덤 넘버는 인터페이스로 만들고 . 구현체를 만든다.


