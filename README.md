# Dagger 2 

> DI 인젝션 라이브러리, 타입에 기반한 인젝션이 이루어지지만, @Scope, @Named, @Qualifier 어노테이션으로 분기 가능


## Subcomponent

- MsgModule

```kotlin
// 모듈로 선언 (의존 주입할 객체 생성)
@Module
class MsgModule {

    @Provides // 객체를 제공하는 메서드에 붙여줌
    @Named("first") // 동일한 두 MsgModel을 다른 객체로 선언하고 싶은 경우 사용
    @PerActivity // 커스텀 스코프로, 어플리케이션 레벨의 컴포넌트는 Singleton 스코프를 가지고 있으며, 하위 컴포넌트는 동일한 스코프 사용이 불가능하기에 커스텀 스코프 선언
    fun provideMsgModel() : MsgModel = MsgModel("이게 첫번쨰")

    @Provides
    @Named("second")
    @PerActivity
    fun provideMsgModelOther() : MsgModel = MsgModel("이건 두번째")
}
```

- MsgComponent

```kotlin

@PerActivity // 커스텀 스코프
@Subcomponent(modules = arrayOf(MsgModule::class)) // 제공할 모듈을 정의함
interface MsgComponent{

    @Subcomponent.Builder // Builder 클래스는 대거가 기본으로 제공하는 Builder를 커스터마이징 할 수 있게 해줌
    interface Builder{
        fun build() : MsgComponent // 반드시 자신을 리턴하는 build()함수를 정의해야함
    }
}
```

- MsgSubModule

```kotlin
/***
* Subcomponent는 상위 컴포넌트와 바인딩 될때, 모듈형태로 제공해야하기에 별도 클래스 생성
*/
@Module(subcomponents = arrayOf(MsgComponent::class))
class MsgSubMoudle
```

- AppComponent

```kotlin

@Singleton // 최상위 컴포넌트의 스코프는 싱글톤으로 선언했음
@Component(modules = arrayOf(ActivityBinder::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    MsgSubMoudle::class,    // 서브 컴포넌트를 상위 컴포넌트에 바인딩
    IntSubModule::class,
    RxModule::class))  
interface AppComponent : AndroidInjector<Dagger2ExampleApp>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder

        fun build() : AppComponent
    }
}
```





## 스코프와 커스터마이징


<br> 

---

## Component.Builder 와 @BindInstance

<br>

#### Component.Builder

> 컴포넌트의 빌더를 커스터마이징할 수 있도록함

#### @BindInstance

> 컴포넌트 내에서 즉각적인 인스턴스를 공급하거나 생성자의 arguments로 들어가는 메소드를 지정함


