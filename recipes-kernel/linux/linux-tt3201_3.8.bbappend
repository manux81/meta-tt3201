FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit kernel
COMPATIBLE_MACHINE_beaglebone = "(beaglebone)"

SRC_URI += " \
 file://0001-added_device_tree_support_for_TT3201_rev5.patch \
 file://0002-fix_makefile.patch \
 file://0003-new_driver_mcp2515.patch \
 file://0004-mcp2515_move_module_info.patch \
 file://0005-update_mcp251x_driver.patch \
 "

