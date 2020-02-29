//import hcsp.Application;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @description:
// * @author: HuFan
// * @time: 2020/2/282:01 下午
// **/
//
///**
// * 返回eureka上所有转换为instanceInfo的实例信息
// *
// * @return instanceInfo列表
// */
//public class OnlyForCopy {
//
//    List<InstanceInfo> getInstanceInfo() {
//        List<InstanceInfo> instanceInfos = new ArrayList<>();
//        List<Application> micors = eurekaClient.getApplications().getRegisteredApplications();
//        for (Application eachMico : micors){
//            List<InstanceInfo> instances = eachMicro.getInstances();
//            instanceInfos.addAll(instances);
//        }
//        return instanceInfos;
//    }
//
//    private static Map<String ,MicroTradeStatisticEntity> caches = new HashMap();  //存放采集的数据
//
//    void searchMetric(List<InstanceInfo> localPart){
//        for(InstanceInfo each : localPart){
//
//        }
//    }
//
//}
//
//class InstanceInfo {
//
//}
