```
 _____      _          _     _ _   _   _      _   _      _                     
/  ___|    | |        | |   (_) | | | | |    | | | |    | |                    
\ `--.  ___| |__  ___ | |    _| |_| |_| | ___| |_| | ___| |_ __   ___ _ __ ___ 
 `--. \/ _ \ '_ \/ __|| |   | | __| __| |/ _ \  _  |/ _ \ | '_ \ / _ \ '__/ __|
/\__/ /  __/ |_) \__ \| |___| | |_| |_| |  __/ | | |  __/ | |_) |  __/ |  \__ \
\____/ \___|_.__/|___/\_____/_|\__|\__|_|\___\_| |_/\___|_| .__/ \___|_|  |___/
                                                          | |                  
                                                          |_|                  

```

Currently this naive implementations only gather running time on chrome browser launched with the `--enable-benchmarking`

# Usage
For the three projects (javajs, scalameter, scalameter-core) do:
```
> publishLocal
```

and then add this line in the build.sbt of the project where you want to use it:
```
libraryDependencies += "com.storm-enroute" %%% "scalameter" % "0.1-SNAPSHOT"
```
