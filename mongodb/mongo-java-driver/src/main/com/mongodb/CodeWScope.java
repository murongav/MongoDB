// CodeWScope.java

/**
 *      Copyright (C) 2008 10gen Inc.
 *  
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.mongodb;

import java.util.*;

/** 
 * for using the CodeWScope type
 */
public class CodeWScope {

    public CodeWScope( String code , DBObject scope ){
        _code = code;
        _scope = scope;
    }

    public String getCode(){
        return _code;
    }

    public DBObject getScope(){
        return _scope;
    }

    final String _code;
    final DBObject _scope;
}

