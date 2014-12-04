DESCRIPTION = "Linux 3.8 stable kernel release"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEFAULT_PREFERENCE = "-1"


inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

RDEPENDS_kernel-base += " kernel-devicetree"
RDEPENDS_kernel-base_append_dra7xx = " vpe-vpdma-fw"

KERNEL_DEVICETREE_beaglebone = "am335x-bone.dtb am335x-boneblack.dtb"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

# The main PR is now using MACHINE_KERNEL_PR, for beagleboard see
# conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "b+gitr${SRCREV}"
PR = "${MACHINE_KERNEL_PR}"

COMPATIBLE_MACHINE = "ti33x"

BRANCH = "3.8.13-bone67-pruspeak"
SRCREV = "49049588554654c4ac27bf7d3a8c52a90a3c3900"
SRC_URI = "git://github.com/beagleboard/linux.git;protocol=https;branch=${BRANCH} \
           file://defconfig \
          "


S = "${WORKDIR}/git"

EXTRA_OEMAKE = "${PARALLEL_MAKE}"

