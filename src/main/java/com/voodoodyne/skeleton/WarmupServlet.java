package com.voodoodyne.skeleton;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 */
@Singleton
@Slf4j
public class WarmupServlet extends HttpServlet {
	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("done");
	}
}
