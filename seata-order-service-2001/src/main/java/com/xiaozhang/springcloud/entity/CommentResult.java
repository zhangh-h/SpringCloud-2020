package com.xiaozhang.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: CommentResult <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:22
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private String  code;
    private String message;

    private T data;

    public CommentResult(String code, String message){
        this(code,message,null);
    }
}
