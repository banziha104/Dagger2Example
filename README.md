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

- MainActivity

```kotlin
class MainActivity : DaggerAppCompatActivity(){

    @Inject @field:Named("first") lateinit var msgModel : MsgModel // @Inject 어노테이션으로 해당 객체에 주입
    @Inject @field:Named("second") lateinit var msgModel2 : MsgModel // @Named("second")를 필드에 적용할 때는 @field:Named("second") 사용
    @Inject lateinit var rx : RxModel
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d("Main","first : ${msgModel.str} ")
        d("Main","second : ${msgModel2.str} ")
        d("Main","객체값 ${rx.obj}")

        rx.obj.subscribe{
            d("Main","메인에서 받은 값 ${it}")
        }

        btnGoSecond.setOnClickListener{
            startActivity<SecondActivity>()

        }
        btnUpScore.setOnClickListener {
            rx.obj.onNext("${num}")
            num++
        }
    }
}
```

# 




## 스코프와 커스터마이징

> Singleton은 어플리케이션의 생명주기와 함께하지만, 각각 프래그먼트나 액티비티의 생명주기와 맞추거나 서브컴포넌트의 사용을
>위해서는 커스텀 스코프를 정의해야함

```kotlin

// 커스텀 스코프를 만드는 어노테이션 클래스
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

```

- MsgComponent

```kotlin

@PerActivity    // 커스텀 스코프 적용
@Subcomponent(modules = arrayOf(MsgModule::class))
interface MsgComponent{

    @Subcomponent.Builder
    interface Builder{

        fun build() : MsgComponent
    }
}

```

<br> 

---

## Component.Builder 와 @BindInstance

<br>

#### Component.Builder

> 컴포넌트의 빌더를 커스터마이징할 수 있도록함

#### @BindInstance

> 컴포넌트 내에서 즉각적인 인스턴스를 공급하거나 생성자의 arguments로 들어가는 메소드를 지정함


```kotlin
@Singleton
@Component(modules = arrayOf(ActivityBinder::class,AndroidSupportInjectionModule::class,AppModule::class,MsgSubMoudle::class,IntSubModule::class,RxModule::class))
interface AppComponent : AndroidInjector<Dagger2ExampleApp>{

    @Component.Builder // 컴포넌트의 빌더를 커스터마이징 할수 있도록함
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder // context와 같이 즉각적으로 받아와야하는 객체는 @BindsInstance를 이용해 가져옮

        fun build() : AppComponent // 반드시 자신을 리턴하는 build() 메서드를 포함해야함
    }
}
```

## 안드로이드의 인젝션

>  액티비티와 프래그먼트와 같이 안드로이드OS상에서 운용되는 정보는 상기 방법으로 가져오기에 제한됌. 그럼으로 서포트 라이브러리를 이용


- ActivityBinder

```kotlin

@Module
abstract class ActivityBinder{
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MsgModule::class)) // 액티비티에 바인딩하는 경우에는 @ContributesAndroidInjector를 사용함
    abstract fun bindMainActivity() : MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(IntModule::class))
    abstract fun bindSecondActivity() : SecondActivity
}
```

- AppComponent

```kotlin
@Singleton
@Component(modules = arrayOf(ActivityBinder::class,AndroidSupportInjectionModule::class,AppModule::class,MsgSubMoudle::class,IntSubModule::class,RxModule::class))
interface AppComponent : AndroidInjector<Dagger2ExampleApp>{ // AndroidInjector<>를 통해 Activity에 의존성 주입이 가능함

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun setMyContext(context : Context) : Builder

        fun build() : AppComponent
    }
}
```

- Dagger2ExampleApp

```kotlin
class Dagger2ExampleApp : DaggerApplication(){ // DaggerApplication을 상속함
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> { // 이때 applicationInjector를 구현해줌
        return DaggerAppComponent.builder().setMyContext(this).build()
    }
}
```

- MainActivity

```kotlin
class MainActivity : DaggerAppCompatActivity(){ // DaggerAppCompatActivity 를 상속함으로써 각 액티비티에 적용가능

    @Inject @field:Named("first") lateinit var msgModel : MsgModel
    @Inject @field:Named("second") lateinit var msgModel2 : MsgModel
    @Inject lateinit var rx : RxModel
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d("Main","first : ${msgModel.str} ")
        d("Main","second : ${msgModel2.str} ")
        d("Main","객체값 ${rx.obj}")

        rx.obj.subscribe{
            d("Main","메인에서 받은 값 ${it}")
        }

        btnGoSecond.setOnClickListener{
            startActivity<SecondActivity>()

        }
        btnUpScore.setOnClickListener {
            rx.obj.onNext("${num}")
            num++
        }
    }
}
```