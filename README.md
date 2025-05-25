# 36-COLLABORATION-ANDROID-HYUNDAICARDDIVE
36기 합동세미나 모바일 앱 1팀 현대카드 다이브 안드로이드 레포입니다.


<img src="https://github.com/user-attachments/assets/395f2104-0f68-4207-8b39-382f3c3754a6" width="800"/>


<br/>
<br/>
<br/>

<h2>
  <img src="https://github.com/user-attachments/assets/541e56b9-aafa-483a-9236-a41e7cb010f6" width="24" style="vertical-align: middle; border-radius: 50%;" />
  Contributors
</h2>

| [송민서 (LEAD)](https://github.com/MinseoSONG) | [김혜정](https://github.com/mjeong21) | [공승준](https://github.com/seungjunGong) |
|:---------------------------:|:-------------------------:|:------------------------------:|
| <img src="https://github.com/user-attachments/assets/f8124d50-eeab-4e28-b283-1dcd9057a306" alt="민서" width="250"/> | <img src="https://github.com/user-attachments/assets/30d5ff97-e811-4487-854f-ec6b306db48f" alt="혜정" width="250"/> | <img src="https://github.com/user-attachments/assets/a28ca35e-77a1-4342-9282-7726a24cbd0f" alt="승준" width="250"/> |
|  `홈 뷰`    |       `공간 상세 뷰`       |      `공간-문화 뷰` <br> `공간 소개 뷰`      |
<br>


## 🎬 Video 

https://github.com/user-attachments/assets/04bc3d26-4092-4a36-8856-76236f1df518

<br/>


## 🧰 기술 스택
| 분류               | 사용 기술                    |
| ---------------- | ------------------------ |
| Architecture     | MVVM, Clean Architecture |
| Language         | Kotlin                   |
| UI               | Jetpack Compose          |
| DI               | Hilt                     |
| Image Loading    | Coil                     |
| Logging          | Timber                   |
| Lint / Formatter | ktlint                   |

<br/>

<h2>
  <img src="https://github.com/user-attachments/assets/541e56b9-aafa-483a-9236-a41e7cb010f6" width="24" style="vertical-align: middle; border-radius: 50%;" />
  Package Structure
</h2>

```
📂 org.sopt.hyundcarddive
┣ 📂 data
┃ ┣ 📂 datasource
┃ ┣ 📂 datasourceimpl
┃ ┣ 📂 mapper
┃ ┣ 📂 model
┃ ┃ ┣ 📂 request
┃ ┃ ┣ 📂 response
┃ ┣ 📂 repository
┃ ┣ 📂 service

┣ 📂 di

┣ 📂 domain
┃ ┣ 📂 model
┃ ┣ 📂 repository

┣ 📂 presentation
┃ ┣ 📂 model
┃ ┣ 📂 ui
┃ ┃ ┣ 📂 component
┃ ┃ ┣ 📂 main
┣ 📂 theme
┣ 📂 util
```
