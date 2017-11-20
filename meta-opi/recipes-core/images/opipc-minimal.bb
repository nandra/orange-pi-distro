SUMMARY = "Small console image for Orange Pi Pc"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
  openssh openssh-keygen \
  kernel-modules \
  mali \
"

EXTRA_TOOLS_INSTALL = " \
  mtd-utils \
  ioquake3 \
  mesa-demos \
"

IMAGE_INSTALL += " \
  ${CORE_OS} \
  ${EXTRA_TOOLS_INSTALL} \
"

IMAGE_FEATURES += "package-management x11"
