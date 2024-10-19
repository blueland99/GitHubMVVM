# GitHubMVVM

이 프로젝트는 MVVM 아키텍처를 사용하여 GitHub API를 연동한 예제입니다. MVVM 패턴을 적용하여 코드 구조를 명확히 하고, GitHub API에서 받아온 데이터를 화면에 표시하는 방식으로 동작합니다. 이 프로젝트는 XML 기반 UI로 구성되어 있으며, 데이터 바인딩을 활용하여 UI와 데이터 로직을 분리합니다.

## 기술 스택

- **언어**: Kotlin
- **아키텍처 패턴**: MVVM (Model-View-ViewModel)
- **네트워킹**: Retrofit
- **비동기 처리**: Coroutines
- **의존성 주입**: Hilt
- **UI**: Android XML, DataBinding

## 주요 기능

- **GitHub API 연동**: GitHub의 공개 API를 통해 레포지토리 정보를 받아와 화면에 표시합니다.
- **MVVM 구조**: Model, View, ViewModel로 명확히 구분된 아키텍처를 사용하여 UI와 비즈니스 로직을 분리했습니다.
- **비동기 네트워크 처리**: Kotlin Coroutines를 사용하여 비동기적으로 API 요청을 처리하고, UI를 업데이트합니다.
- **의존성 주입**: Hilt를 사용하여 네트워크 및 데이터 관련 의존성을 주입합니다.
- **DataBinding**: View와 ViewModel 간의 데이터를 자동으로 동기화하여 XML 레이아웃에 데이터를 바인딩합니다.

## MVVM 구조 설명

- **Model**: API 호출을 처리하고, 데이터를 ViewModel로 전달하는 역할을 합니다. Retrofit을 사용하여 GitHub API와 통신합니다.
- **ViewModel**: UI에 필요한 데이터를 관리하고, 비동기 작업을 처리합니다. LiveData를 사용하여 UI에 데이터 변화를 전달합니다.
- **View**: XML 레이아웃과 DataBinding을 활용해 UI를 구성하고, ViewModel과 상호작용합니다. ViewModel에서 전달받은 데이터를 바탕으로 UI를 업데이트합니다.