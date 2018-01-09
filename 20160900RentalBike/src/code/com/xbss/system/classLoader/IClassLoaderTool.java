package com.xbss.system.classLoader;

import java.util.List;

public interface IClassLoaderTool {

	public abstract List<Class<?>> loaderClassInPackage(String packagePath);

	public abstract Class<?> loaderClass(String classPath)
			throws ClassNotFoundException;

	public abstract List<String> getClassNameInPackage(String packagePath);

}