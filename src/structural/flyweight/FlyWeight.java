package structural.flyweight;

public class FlyWeight {
    /*
    When we are dealing with huge system, the number of objects used are really expensive, so if are duplicating some of the attributes again and again then it will consume more memory and makes the system slower. So split the class into shared class and extrinsic class, the extrinsic class uses the shared object as they have same characteristics.

    For eg: in file system, when we want display file icon folder icon, then creating it every time will be waste of resource and more consuming task, so keep this shared object in the flyweight factory, we can cache this shared objects for further uses also, and the actual class where it is being used, we can use the flyweight factory to create the object and cache it for further use.

     */
}
