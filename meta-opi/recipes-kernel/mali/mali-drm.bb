SUMMARY = "Mali-400 driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

inherit module

DEPENDS += "xz-native bc-native"

PV = "0.1"
PR = "r0"

COMPATIBLE_MACHINE = "orange-pi-pc"

SRCREV = "5b7b3c0b6e1736676c90928816d271debbb09d95"

SRC_URI = " \
  git://github.com/mripard/sunxi-mali.git;protocol=git \
  file://Modify-Makefile.patch \
"

S = "${WORKDIR}/git/r6p2/src/egl/x11/drm_module/mali_drm/mali"

do_patch[dirs] = "${WORKDIR} ${WORKDIR}/git/patches"

KERNEL_MODULE_AUTOLOAD += "mali_drm"
