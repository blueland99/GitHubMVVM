# Android GitHub MVVM 프로젝트

이 프로젝트는 Android 애플리케이션에서 Model-View-ViewModel (MVVM) 패턴을 사용하여 GitHub API와 상호작용하는 예제를 제공합니다. 프로젝트의 주요 목적은 MVVM 아키텍처를 학습하고 구현하는 것입니다. 이 애플리케이션은 GitHub 사용자 목록을 가져와 표시합니다.

## 주요 기능

- **MVVM 아키텍처**: 데이터, 비즈니스 로직, UI 로직의 명확한 분리를 통해 코드의 유지보수성과 확장성을 높입니다.
- **Dagger Hilt**: 의존성 주입을 통해 코드의 결합도를 낮추고 모듈화를 쉽게 합니다.
- **Retrofit**: GitHub API와의 네트워크 통신을 처리합니다.
- **LiveData와 ViewModel**: 생명주기를 인식하는 데이터 관리를 통해 UI 데이터를 효율적으로 관리합니다.
- **Coroutines**: 비동기 작업을 간단하게 처리하여 네트워크 작업을 수행합니다.

## 프로젝트 구조

- **data**: 데이터 작업을 처리합니다. 모델, 리포지토리 구현 및 원격 데이터 소스를 포함합니다.
    - **model**: 데이터 모델 (`UserEntity`, `UserListEntity`).
    - **repository**: 데이터 접근을 추상화하는 리포지토리 패턴.
    - **source**: 데이터 소스 (`remote`는 API 서비스 및 데이터 소스 구현을 포함).
- **domain**: 비즈니스 로직을 포함합니다.
    - **model**: 도메인 모델 (`User`).
    - **repository**: 리포지토리 인터페이스.
    - **usecase**: 다양한 작업을 위한 유스케이스 (`GetUsersUseCase`).
- **presentation**: UI 계층 및 사용자 상호작용을 관리합니다.
    - **view**: UI 컴포넌트 (예: `MainActivity`).
    - **viewmodel**: UI 관련 데이터를 관리하는 ViewModel.
    - **adapter**: RecyclerView 어댑터.
- **di**: Dagger Hilt를 사용한 의존성 주입 설정.
    - **AppModule**: 애플리케이션 수준의 의존성을 제공합니다.

## 동작 원리

1. **데이터 가져오기**: `UserRemoteDataSource` 클래스는 Retrofit을 사용하여 GitHub API에서 유저 데이터를 가져옵니다.
2. **리포지토리 패턴**: `UserRepositoryImpl`은 원격 데이터 소스와 상호작용하여 데이터를 가져오고, 이를 도메인 모델로 매핑합니다.
3. **유스케이스**: `GetUsersUseCase`는 유저를 가져오는 간단한 API를 제공하며, ViewModel에서 사용됩니다.
4. **ViewModel**: `UserViewModel`은 유스케이스를 사용하여 데이터를 가져오고, 이를 LiveData를 통해 UI에 노출합니다.
5. **UI 계층**: `MainActivity`는 ViewModel에서 LiveData를 관찰하고, 데이터를 RecyclerView 어댑터에 설정합니다.