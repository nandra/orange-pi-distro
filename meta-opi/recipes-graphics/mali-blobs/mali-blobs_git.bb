SUMMARY = "Mali-400 userspace blobs"
LICENSE = "CLOSED"

PROVIDES = "virtual/egl virtual/libegl virtual/libgles1 virtual/libgles2"
RPROVIDES_${PN} = "libegl"

RDEPENDS_${PN} += "libdrm libxdamage libxfixes libxext libx11"

INSANE_SKIP_${PN} = "dev-so"


SRC_URI = " \
  git://github.com/free-electrons/mali-blobs.git;branch=master \
  file://egl.pc \
  file://gles_cm.pc \
  file://glesv2.pc \
"

SRCREV = "cb3e8ece9b2c3a70cbeb3204cd6f30eceaa32023"

S= "${WORKDIR}/git"

do_install() {
  install -d ${D}${exec_prefix}
  tar -xf ${S}/r6p2/x11_ump/lib/lib_x11_ump.tar.bz2 -C ${D}${exec_prefix}
  mv ${D}${exec_prefix}/lib_x11 ${D}${libdir}

  install -d ${D}${libdir}/pkgconfig
  install -m 0644 ${WORKDIR}/*.pc ${D}${libdir}/pkgconfig/

  install -d ${D}${includedir}/EGL
  install -d ${D}${includedir}/GLES
  install -d ${D}${includedir}/GLES2
  install -d ${D}${includedir}/KHR

  install -m 0644 ${S}/r6p2/x11_ump/include/EGL/* ${D}${includedir}/EGL/
  install -m 0644 ${S}/r6p2/x11_ump/include/GLES/* ${D}${includedir}/GLES/
  install -m 0644 ${S}/r6p2/x11_ump/include/GLES2/* ${D}${includedir}/GLES2/
  install -m 0644 ${S}/r6p2/x11_ump/include/KHR/* ${D}${includedir}/KHR/
}

FILES_${PN} = "${libdir}/*"
FILES_${PN}-dev = "${includedir}/*"
