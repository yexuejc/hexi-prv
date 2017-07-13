# 学习RxJava+Retrofit+OkHttp框架的demo #

## 说明 ##
> 1.使用MVP架构
>
> 2.使用RxJava+Retrofit+OkHttp框架

## 使用解析 ##
> (1).ui        -->     UI层与Presenter层
>
>       1)*Activity   -->activity
>       I*View      -->activity与presenter的交互接口
>       *Presenter  -->presenter
>
>       2).ui.base      -->VP层super
>            2.1)BaseActivity    -->所有activity super,里面包含加载框
>            2.2)BasePresenter   -->所有presenter super,初始化View和Context
>            2.3)MvpActivty      -->继承自BaseActivity,实例化presenter
>
> (2).model    -->     model层
>
>       1)  BaseModel  -->super model. 所有modelImpl的继承父类
>
>       2)  model 接口 -->网络请求方法
> (3).bean    -->      实体，包含普通bean,数据库entity、返回结果Result等
>
> (4).sys     -->      系统（全局）级的处理
>
> (5).utils   -->       工具包

## 使用步骤 ##
1.创建activity继承MvpActivity
> (1).  ceatePresenter()实例化presenter

```
    @Override
protected MainPresenter ceatePresenter() {
    return new MainPresenter(subscription);
}
```
> (2). onInitLayoutBefore()加载layout

```
    @Override
protected void onInitLayoutBefore() {
    loadUI(this, R.layout.activity_main);
}
```
> (3). activity中onInitLayoutAfter()之后调用objBeanPresenter.*()方法

```
     @Override
protected void onInitLayoutAfter() {
    showLoadingDialog();//显示加载框
    objBeanPresenter.loadInit();//到presenter去处理逻辑（加载数据）
}
```
> (4).请求结果（更改UI）数据和隐藏加载框的处理放回UI(activity)处理，通过presenter调用I*View接口实现回调

```
  @Override
public void updateInit(String resultStr) {
    hideLoadingDialog();
    pptIcoListAll.setText(resultStr);
}
```
2.presenter
> (1).调用model请求数据

```
public void loadInit() {
        /***
         * 请求第一种方式
         */
        subscription = PptIcoImpl.getPptIco()//获取PptIco model实例
                .listALL()//请方法
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getInitObservable(ResultPptIcoGsonFormat.class));
                //观察者模式订阅(创建观察者 (返回数据类型 ))
    }
```
> (2).创建观察者级回调处理

```
 private <S> BaseObserver getInitObservable(final Class<S> resultDataClass) {
        return new BaseObserver<ResultData<S>>(new BaseObserver.HttpCallBack<ResultData<S>>() {
            @Override
            public void onComplete(int code, ResultData<S> resultDataClass) {
                onComplete4Init(code, resultDataClass);//okHttp请求网络之后回调
            }
        });
    }
```
> (3).回调处理 *ps:根据自己的逻辑处理*

```
 private <S> void onComplete4Init(int code, ResultData<S> resultDataClass) {
        String resultStr = "";
        switch (code) {
            case 200://请求成功
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(resultDataClass.toString());
                System.out.println(json);
                Log.e("resule", json);
                resultStr = json;
                break;
            case 500://请求失败
                T.showShort(getContext(), getContext().getString(R.string.error_code_500));
                break;
        }
        //返回到UI的处理 *ps: 更改UI数据通过view回调到UI(activity)*
        IMainView view = getView();
        if (view != null) {
            view.updateInit(resultStr);
        }
    }
```