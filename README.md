# 영화정보 검색 어플리케이션
## 설명
- 네이버 검색 API를 활용하여 영화정보를 검색하는 어플리케이션 제작
- 사용자로부터 검색어를 입력받아 검색결과 목록을 표시

## 예시화면 및 영상
- 아래 화면은 예시 화면이며 아래와 같은 화면구성, 기능을 구현 하면 됩니다.
- [예제 APK 다운로드](https://github.com/boostcamp-connect/boostcamp_3_Android/raw/master/app-release.apk)
<br><br>

![Screenshot](https://github.com/boostcamp-connect/boostcamp_3_Android/blob/master/screenshot1.jpg?raw=true)  ![Screenshot](https://github.com/boostcamp-connect/boostcamp_3_Android/blob/master/screenshot2.gif?raw=true)


# 구현
## 필수 구현사항

- EditText를 통해 검색어를 입력받아 `검색`버튼으로 영화 검색
- [네이버 검색 API](https://developers.naver.com/docs/search/movie/)를 활용하여 검색어에 해당하는 결과 받아오기
- 검색결과를 RecyclerView에 표시하기
- 각 영화정보에는 아래 정보가 모두 표시
: 썸네일 이미지, 제목, 평점, 연도, 감독, 출연배우
- 목록에서 영화 선택시 해당 영화 정보 link페이지로 이동
## 선택 구현사항
필수 구현사항은 아니지만 아래 내용을 구현한경우 가산점을 받습니다.
### 구조 및 라이브러리
- RxJava 사용
- Databinding 사용
- MVP / MVVM / MVI 패턴 사용

### 기능 구현
- 검색결과 무한 스크롤 구현
- 유효하지 않은 검색어, 검색결과 처리
- 기타 알수 없는 에러발생 처리

# API 정보
- https://developers.naver.com/docs/search/movie/

### 검색
`https://openapi.naver.com/v1/search/movie.json`
#### Header
- X-Naver-Client-Id (발급받은 앱의 Client id)
- X-Naver-Client-Secret (발급받은 앱의 Secret key)
#### Params
- Query (검색어)


# 과제제출 방법
- 본인의 Github 계정에 과제 Repository를 만들고 Repository 주소 명시

# 기타
- 과제구현 질문은 [Issues탭](https://github.com/boostcamp-connect/boostcamp_3_Android/issues)에 등록해주시면 답변드립니다.
- 선택 구현사항외에도 본인의 노하우, 실력을 뽐낼 수 있는 기술이나 코드가 있다면 포함할경우 추가로 가산점을 받게 됩니다.
