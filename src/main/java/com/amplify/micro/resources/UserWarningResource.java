package com.amplify.micro.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.amplify.micro.core.UserWarning;
import com.amplify.micro.db.UserWarningDAO;
import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;


/**
 * Created with IntelliJ IDEA.
 * User: thuang
 * Date: 9/22/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/userWarning")
@Produces(MediaType.APPLICATION_JSON)
public class UserWarningResource {

    private final UserWarningDAO userWarningDao;

    public UserWarningResource(UserWarningDAO userWarningDao) {
        this.userWarningDao = userWarningDao;
    }

    @GET
    @Path("/id/{userWarningId}")
    @UnitOfWork
    public UserWarning findWarning(@PathParam("userWarningId")LongParam userWarningId) {
        return userWarningDao.findById(userWarningId.get());
    }

    @GET
    @Path("/bk/{bk}")
    @UnitOfWork
    public UserWarning findWarningByBK(@PathParam("bk") String businessKey) {
        return userWarningDao.findByBK(businessKey);
    }

    @GET
    @Path("/bk-sql/{bk}")
    @UnitOfWork
    public String findWarningByBKSQL(@PathParam("bk") String businessKey) {
        return userWarningDao.findByBKSql(businessKey);
    }
}
