package com.sanjogstha.codewars.remote;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ApiConstant {
    static final String BASE_URL = "https://www.codewars.com/api/v1/";

    /*This endpoint returns information about a specific user.*/
    static final String GET_USER_INFO_URL = "users/{username}";

    /*This endpoint returns a list of all code challenges completed by a given user.
     By default only the first 200 code challenges will be returned.
     You can page the results using the page param. The param is zero based.*/
    static final String COMPLETED_CHALLENGE_URL = GET_USER_INFO_URL +
            "/code-challenges/completed?page=0";

    /*This endpoint returns a list of all code challenges authored by a given user*/
    static final String AUTHORED_CHALLENGE_URL = GET_USER_INFO_URL + "/code-challenges/authored";

    /*This endpoint returns information about a specific code challenge (kata).*/
    protected static final String CHALLENGE_INFO_URL = BASE_URL +
            "code-challenges/{slug}";
}
