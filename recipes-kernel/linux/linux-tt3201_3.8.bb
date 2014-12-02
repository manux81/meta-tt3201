DESCRIPTION = "Linux 3.8 stable kernel release"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "beaglebone"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

RDEPENDS_kernel-base_append_dra7xx = " vpe-vpdma-fw"

KERNEL_DEVICETREE_beaglebone = "am335x-bone.dtb am335x-boneblack.dtb"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

# The main PR is now using MACHINE_KERNEL_PR, for beagleboard see
# conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "b+gitr${SRCREV}"
PR = "${MACHINE_KERNEL_PR}"

COMPATIBLE_MACHINE = "ti33x"

BRANCH = "towertech-tt3201-can-cape"
SRCREV = "83e43b4ca4b8c153ec5ffd526575b4c6eb436a34"

SRC_URI = "git://github.com/dwery/beagleboard-linux.git;protocol=https;branch=${BRANCH} \
           file://defconfig \
          "


S = "${WORKDIR}/git"

EXTRA_OEMAKE = "${PARALLEL_MAKE}"

