java.lang.IllegalArgumentException: Could not find a 'KafkaServer' or 'sasl_ssl.KafkaServer' entry in the JAAS configuration. System property 'java.security.auth.login.config' is not set
        at org.apache.kafka.common.security.JaasContext.defaultContext(JaasContext.java:131)
        at org.apache.kafka.common.security.JaasContext.load(JaasContext.java:96)
        at org.apache.kafka.common.security.JaasContext.loadServerContext(JaasContext.java:69)
        at org.apache.kafka.common.network.ChannelBuilders.create(ChannelBuilders.java:168)
        at org.apache.kafka.common.network.ChannelBuilders.clientChannelBuilder(ChannelBuilders.java:81)
        at kafka.server.BrokerToControllerChannelManagerImpl.newRequestThread(BrokerToControllerChannelManager.scala:189)
        at kafka.server.BrokerToControllerChannelManagerImpl.<init>(BrokerToControllerChannelManager.scala:168)
        at kafka.server.BrokerToControllerChannelManager$.apply(BrokerToControllerChannelManager.scala:131)
        at kafka.server.KafkaServer.startup(KafkaServer.scala:271)
        at kafka.Kafka$.main(Kafka.scala:109)
        at kafka.Kafka.main(Kafka.scala)
[2024-05-09 20:22:41,189] INFO [KafkaServer id=0] shutting down (kafka.server.KafkaServer)
[2024-05-09 20:22:41,192] INFO Shutting down. (kafka.log.LogManager)
[2024-05-09 20:22:41,280] ERROR Error while writing to checkpoint file E:\kafka\data\broker\recovery-point-offset-checkpoint (kafka.server.LogDirFailureChannel)
java.nio.file.AccessDeniedException: E:\kafka\data\broker
        at java.base/sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:89)
        at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:103)
        at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:108)
        at java.base/sun.nio.fs.WindowsFileSystemProvider.newFileChannel(WindowsFileSystemProvider.java:116)
        at java.base/java.nio.channels.FileChannel.open(FileChannel.java:292)
        at java.base/java.nio.channels.FileChannel.open(FileChannel.java:345)
        at org.apache.kafka.common.utils.Utils.flushDir(Utils.java:953)
        at org.apache.kafka.common.utils.Utils.atomicMoveWithFallback(Utils.java:941)
        at org.apache.kafka.common.utils.Utils.atomicMoveWithFallback(Utils.java:916)
        at kafka.server.checkpoints.CheckpointFile.liftedTree1$1(CheckpointFile.scala:114)
        at kafka.server.checkpoints.CheckpointFile.write(CheckpointFile.scala:92)
        at kafka.server.checkpoints.OffsetCheckpointFile.write(OffsetCheckpointFile.scala:67)
        at kafka.log.LogManager.$anonfun$checkpointRecoveryOffsetsInDir$1(LogManager.scala:675)
        at kafka.log.LogManager.$anonfun$checkpointRecoveryOffsetsInDir$1$adapted(LogManager.scala:671)
        at scala.Option.foreach(Option.scala:407)
        at kafka.log.LogManager.checkpointRecoveryOffsetsInDir(LogManager.scala:671)
        at kafka.log.LogManager.$anonfun$shutdown$9(LogManager.scala:542)
        at kafka.log.LogManager.$anonfun$shutdown$9$adapted(LogManager.scala:535)
        at kafka.utils.Implicits$MapExtensionMethods$.$anonfun$forKeyValue$1(Implicits.scala:62)
        at scala.collection.compat.MapExtensionMethods$.$anonfun$foreachEntry$1(PackageShared.scala:431)
        at scala.collection.mutable.HashMap.$anonfun$foreach$1(HashMap.scala:149)
        at scala.collection.mutable.HashTable.foreachEntry(HashTable.scala:237)
        at scala.collection.mutable.HashTable.foreachEntry$(HashTable.scala:230)
        at scala.collection.mutable.HashMap.foreachEntry(HashMap.scala:44)
        at scala.collection.mutable.HashMap.foreach(HashMap.scala:149)
        at scala.collection.compat.MapExtensionMethods$.foreachEntry$extension(PackageShared.scala:431)
        at kafka.log.LogManager.shutdown(LogManager.scala:535)
        at kafka.server.KafkaServer.$anonfun$shutdown$18(KafkaServer.scala:701)
        at kafka.utils.CoreUtils$.swallow(CoreUtils.scala:68)
        at kafka.server.KafkaServer.shutdown(KafkaServer.scala:701)
        at kafka.server.KafkaServer.startup(KafkaServer.scala:435)
        at kafka.Kafka$.main(Kafka.scala:109)
        at kafka.Kafka.main(Kafka.scala)
[2024-05-09 20:22:41,594] ERROR Disk error while writing recovery offsets checkpoint in directory E:\kafka\data\broker: Error while writing to checkpoint file E:\kafka\data\broker\recovery-point-offset-checkpoint (kafka.log.LogManager)
[2024-05-09 20:22:41,622] ERROR Error while writing to checkpoint file E:\kafka\data\broker\log-start-offset-checkpoint (kafka.server.LogDirFailureChannel)
java.nio.file.AccessDeniedException: E:\kafka\data\broker
        at java.base/sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:89)
        at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:103)
        at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:108)
        at java.base/sun.nio.fs.WindowsFileSystemProvider.newFileChannel(WindowsFileSystemProvider.java:116)
        at java.base/java.nio.channels.FileChannel.open(FileChannel.java:292)
        at java.base/java.nio.channels.FileChannel.open(FileChannel.java:345)
        at org.apache.kafka.common.utils.Utils.flushDir(Utils.java:953)
        at org.apache.kafka.common.utils.Utils.atomicMoveWithFallback(Utils.java:941)
        at org.apache.kafka.common.utils.Utils.atomicMoveWithFallback(Utils.java:916)
        at kafka.server.checkpoints.CheckpointFile.liftedTree1$1(CheckpointFile.scala:114)
        at kafka.server.checkpoints.CheckpointFile.write(CheckpointFile.scala:92)
        at kafka.server.checkpoints.OffsetCheckpointFile.write(OffsetCheckpointFile.scala:67)
        at kafka.log.LogManager.$anonfun$checkpointLogStartOffsetsInDir$1(LogManager.scala:698)
        at kafka.log.LogManager.$anonfun$checkpointLogStartOffsetsInDir$1$adapted(LogManager.scala:694)
        at scala.Option.foreach(Option.scala:407)
        at kafka.log.LogManager.checkpointLogStartOffsetsInDir(LogManager.scala:694)
        at kafka.log.LogManager.$anonfun$shutdown$9(LogManager.scala:545)
        at kafka.log.LogManager.$anonfun$shutdown$9$adapted(LogManager.scala:535)
        at kafka.utils.Implicits$MapExtensionMethods$.$anonfun$forKeyValue$1(Implicits.scala:62)
        at scala.collection.compat.MapExtensionMethods$.$anonfun$foreachEntry$1(PackageShared.scala:431)
        at scala.collection.mutable.HashMap.$anonfun$foreach$1(HashMap.scala:149)
        at scala.collection.mutable.HashTable.foreachEntry(HashTable.scala:237)
        at scala.collection.mutable.HashTable.foreachEntry$(HashTable.scala:230)
        at scala.collection.mutable.HashMap.foreachEntry(HashMap.scala:44)
        at scala.collection.mutable.HashMap.foreach(HashMap.scala:149)
        at scala.collection.compat.MapExtensionMethods$.foreachEntry$extension(PackageShared.scala:431)
        at kafka.log.LogManager.shutdown(LogManager.scala:535)
        at kafka.server.KafkaServer.$anonfun$shutdown$18(KafkaServer.scala:701)
        at kafka.utils.CoreUtils$.swallow(CoreUtils.scala:68)
        at kafka.server.KafkaServer.shutdown(KafkaServer.scala:701)
        at kafka.server.KafkaServer.startup(KafkaServer.scala:435)
        at kafka.Kafka$.main(Kafka.scala:109)
        at kafka.Kafka.main(Kafka.scala)
[2024-05-09 20:22:41,625] ERROR Disk error while writing log start offsets checkpoint in directory E:\kafka\data\broker: Error while writing to checkpoint file E:\kafka\data\broker\log-start-offset-checkpoint (kafka.log.LogManager)
[2024-05-09 20:22:41,627] INFO Shutdown complete. (kafka.log.LogManager)
[2024-05-09 20:22:41,632] INFO [feature-zk-node-event-process-thread]: Shutting down (kafka.server.FinalizedFeatureChangeListener$ChangeNotificationProcessorThread)
[2024-05-09 20:22:41,633] INFO [feature-zk-node-event-process-thread]: Stopped (kafka.server.FinalizedFeatureChangeListener$ChangeNotificationProcessorThread)
[2024-05-09 20:22:41,633] INFO [feature-zk-node-event-process-thread]: Shutdown completed (kafka.server.FinalizedFeatureChangeListener$ChangeNotificationProcessorThread)
[2024-05-09 20:22:41,634] INFO [ZooKeeperClient Kafka server] Closing. (kafka.zookeeper.ZooKeeperClient)
[2024-05-09 20:22:41,747] INFO Session: 0x1003a54273c0000 closed (org.apache.zookeeper.ZooKeeper)
[2024-05-09 20:22:41,747] INFO EventThread shut down for session: 0x1003a54273c0000 (org.apache.zookeeper.ClientCnxn)
[2024-05-09 20:22:41,749] INFO [ZooKeeperClient Kafka server] Closed. (kafka.zookeeper.ZooKeeperClient)
[2024-05-09 20:22:41,749] INFO [ThrottledChannelReaper-Fetch]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:41,761] INFO [ThrottledChannelReaper-Fetch]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:41,761] INFO [ThrottledChannelReaper-Produce]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:41,761] INFO [ThrottledChannelReaper-Fetch]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:42,769] INFO [ThrottledChannelReaper-Produce]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:42,769] INFO [ThrottledChannelReaper-Request]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:42,769] INFO [ThrottledChannelReaper-Produce]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:43,775] INFO [ThrottledChannelReaper-Request]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:43,775] INFO [ThrottledChannelReaper-Request]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)        
[2024-05-09 20:22:43,776] INFO [ThrottledChannelReaper-ControllerMutation]: Shutting down (kafka.server.ClientQuotaManager$ThrottledChannelReaper)  
[2024-05-09 20:22:44,781] INFO [ThrottledChannelReaper-ControllerMutation]: Stopped (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:44,781] INFO [ThrottledChannelReaper-ControllerMutation]: Shutdown completed (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2024-05-09 20:22:44,783] INFO Metrics scheduler closed (org.apache.kafka.common.metrics.Metrics)
[2024-05-09 20:22:44,783] INFO Closing reporter org.apache.kafka.common.metrics.JmxReporter (org.apache.kafka.common.metrics.Metrics)
[2024-05-09 20:22:44,783] INFO Metrics reporters closed (org.apache.kafka.common.metrics.Metrics)
[2024-05-09 20:22:44,785] INFO Broker and topic stats closed (kafka.server.BrokerTopicStats)
[2024-05-09 20:22:44,790] INFO App info kafka.server for 0 unregistered (org.apache.kafka.common.utils.AppInfoParser)
[2024-05-09 20:22:44,790] INFO [KafkaServer id=0] shut down completed (kafka.server.KafkaServer)
[2024-05-09 20:22:44,791] ERROR Exiting Kafka. (kafka.Kafka$)
[2024-05-09 20:22:44,792] INFO [KafkaServer id=0] shutting down (kafka.server.KafkaServer)