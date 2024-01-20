package com.hjq.http.model;

import androidx.annotation.NonNull;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/EasyHttp
 *    time   : 2019/12/14
 *    desc   : 请求对象代理
 */
public final class CallProxy implements Call {

    private Call mRealCall;

    public CallProxy(@NonNull Call realCall) {
        mRealCall = realCall;
    }

    public void setRealCall(@NonNull Call call) {
        mRealCall = call;
    }

    public Call getRealCall() {
        return mRealCall;
    }

    @NonNull
    @Override
    public Request request() {
        return mRealCall.request();
    }

    @NonNull
    @Override
    public Response execute() throws IOException {
        return mRealCall.execute();
    }

    @Override
    public void enqueue(@NonNull Callback responseCallback) {
        mRealCall.enqueue(responseCallback);
    }

    @Override
    public void cancel() {
        mRealCall.cancel();
    }

    @Override
    public boolean isExecuted() {
        return mRealCall.isExecuted();
    }

    @Override
    public boolean isCanceled() {
        return mRealCall.isCanceled();
    }

    @NonNull
    @Override
    public Timeout timeout() {
        return mRealCall.timeout();
    }

    @NonNull
    @Override
    public Call clone() {
        return mRealCall.clone();
    }

    public interface Factory {

        CallProxy create();
    }
}