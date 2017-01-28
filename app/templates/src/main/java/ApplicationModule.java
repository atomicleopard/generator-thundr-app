import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;
import com.threewks.thundr.platform.DefaultPlatformModule;
import com.threewks.thundr.route.Router;
import com.threewks.thundr.servlet.ServletModule;
import com.threewks.thundr.view.jsp.JspModule;

import controllers.Routes;

public class ApplicationModule extends BaseModule {
	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
		dependencyRegistry.addDependency(DefaultPlatformModule.class);
		dependencyRegistry.addDependency(ServletModule.class);
		dependencyRegistry.addDependency(JspModule.class);
	}

	@Override
	public void configure(UpdatableInjectionContext injectionContext) {
		super.configure(injectionContext);
	}

	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);

		Router router = injectionContext.get(Router.class);
		Routes.addRoutes(router);
	}

}
