# steps to reproduce

Clone this repo

     $ git clone git@github.com:tgippi/quarkus-issue.git
      
Build the quarkus-app

    $ mvn quarkus:dev

And, then, see the stacktrace
<pre>
2020-02-03 20:42:53,467 ERROR [io.qua.application] (main) Failed to start application: java.lang.LinkageError: loader constraint violation: loader 'app' wants to load interface org.axonframework.common.jpa.EntityManagerProvider. A different interface with the same name was previously loaded by io.quarkus.runner.RuntimeClassLoader @15b3e5b. (org.axonframework.common.jpa.EntityManagerProvider is in unnamed module of loader io.quarkus.runner.RuntimeClassLoader @15b3e5b, parent loader java.net.URLClassLoader @548ad73b)
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1016)
        at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:174)
        at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:800)
        at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:698)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:621)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:579)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        at org.axonframework.config.AggregateConfigurer.jpaMappedConfiguration(AggregateConfigurer.java:183)
        at org.acme.quickstart.AxonStarter.startup(AxonStarter.java:28)
        at org.acme.quickstart.AxonStarter_Observer_startup_f43ab41051de39ca1e534f6cd06115c3c9b219b8.notify(AxonStarter_Observer_startup_f43ab41051de39ca1e534f6cd06115c3c9b219b8.zig:111)
        at io.quarkus.arc.impl.EventImpl$Notifier.notifyObservers(EventImpl.java:282)
        at io.quarkus.arc.impl.EventImpl$Notifier.notify(EventImpl.java:267)
        at io.quarkus.arc.impl.EventImpl.fire(EventImpl.java:69)
        at io.quarkus.arc.runtime.LifecycleEventRunner.fireStartupEvent(LifecycleEventRunner.java:23)
        at io.quarkus.arc.runtime.ArcRecorder.handleLifecycleEvents(ArcRecorder.java:108)
        at io.quarkus.deployment.steps.LifecycleEventsBuildStep$startupEvent36.deploy_0(LifecycleEventsBuildStep$startupEvent36.zig:58)
        at io.quarkus.deployment.steps.LifecycleEventsBuildStep$startupEvent36.deploy(LifecycleEventsBuildStep$startupEvent36.zig:77)
        at io.quarkus.runner.ApplicationImpl.doStart(ApplicationImpl.zig:185)
        at io.quarkus.runtime.Application.start(Application.java:87)
        at io.quarkus.runner.RuntimeRunner.run(RuntimeRunner.java:167)
        at io.quarkus.dev.DevModeMain.doStart(DevModeMain.java:178)
        at io.quarkus.dev.DevModeMain.start(DevModeMain.java:96)
        at io.quarkus.dev.DevModeMain.main(DevModeMain.java:67)

2020-02-03 20:42:53,476 ERROR [io.qua.dev.DevModeMain] (main) Failed to start Quarkus: java.lang.RuntimeException: Failed to start quarkus
        at io.quarkus.runner.ApplicationImpl.doStart(ApplicationImpl.zig:215)
        at io.quarkus.runtime.Application.start(Application.java:87)
        at io.quarkus.runner.RuntimeRunner.run(RuntimeRunner.java:167)
        at io.quarkus.dev.DevModeMain.doStart(DevModeMain.java:178)
        at io.quarkus.dev.DevModeMain.start(DevModeMain.java:96)
        at io.quarkus.dev.DevModeMain.main(DevModeMain.java:67)
Caused by: java.lang.LinkageError: loader constraint violation: loader 'app' wants to load interface org.axonframework.common.jpa.EntityManagerProvider. A different interface with the same name was previously loaded by io.quarkus.runner.RuntimeClassLoader @15b3e5b. (org.axonframework.common.jpa.EntityManagerProvider is in unnamed module of loader io.quarkus.runner.RuntimeClassLoader @15b3e5b, parent loader java.net.URLClassLoader @548ad73b)
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1016)
        at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:174)
        at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:800)
        at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:698)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:621)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:579)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        at org.axonframework.config.AggregateConfigurer.jpaMappedConfiguration(AggregateConfigurer.java:183)
        at org.acme.quickstart.AxonStarter.startup(AxonStarter.java:28)
        at org.acme.quickstart.AxonStarter_Observer_startup_f43ab41051de39ca1e534f6cd06115c3c9b219b8.notify(AxonStarter_Observer_startup_f43ab41051de39ca1e534f6cd06115c3c9b219b8.zig:111)
        at io.quarkus.arc.impl.EventImpl$Notifier.notifyObservers(EventImpl.java:282)
        at io.quarkus.arc.impl.EventImpl$Notifier.notify(EventImpl.java:267)
        at io.quarkus.arc.impl.EventImpl.fire(EventImpl.java:69)
        at io.quarkus.arc.runtime.LifecycleEventRunner.fireStartupEvent(LifecycleEventRunner.java:23)
        at io.quarkus.arc.runtime.ArcRecorder.handleLifecycleEvents(ArcRecorder.java:108)
        at io.quarkus.deployment.steps.LifecycleEventsBuildStep$startupEvent36.deploy_0(LifecycleEventsBuildStep$startupEvent36.zig:58)
        at io.quarkus.deployment.steps.LifecycleEventsBuildStep$startupEvent36.deploy(LifecycleEventsBuildStep$startupEvent36.zig:77)
        at io.quarkus.runner.ApplicationImpl.doStart(ApplicationImpl.zig:185)
        ... 5 more
</pre>
