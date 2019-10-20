package com.wuyang.dubbodemoserviceprovider.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.wuyang.dubbodemoserviceapi.domain.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookServiceFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Book book = ((Book)invocation.getArguments()[0]);

        if (book.getPages() > 300) {
            log.warn("这本书的页码超过300页...{}", book.getName());
        }

        return invoker.invoke(invocation);
    }

}
