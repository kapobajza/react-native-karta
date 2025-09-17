#include <jni.h>
#include "KartaOnLoad.hpp"

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void*) {
  return margelo::nitro::karta::initialize(vm);
}
