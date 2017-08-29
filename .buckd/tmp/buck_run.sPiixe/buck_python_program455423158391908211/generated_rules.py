from buck_parser.buck import *

@provide_for_build
def prebuilt_apple_framework(name, framework, preferred_linkage, deps=None, exported_linker_flags=None, exported_platform_linker_flags=None, frameworks=None, labels=None, libraries=None, licenses=None, supported_platforms_regex=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_apple_framework',
        'name': name,
        'framework': framework,
        'preferredLinkage': preferred_linkage,
        'deps': deps,
        'exportedLinkerFlags': exported_linker_flags,
        'exportedPlatformLinkerFlags': exported_platform_linker_flags,
        'frameworks': frameworks,
        'labels': labels,
        'libraries': libraries,
        'licenses': licenses,
        'supportedPlatformsRegex': supported_platforms_regex,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_cxx_library_group(name, deps=None, exported_deps=None, exported_preprocessor_flags=None, include_dirs=None, labels=None, licenses=None, provided_shared_libs=None, shared_libs=None, shared_link=None, static_libs=None, static_link=None, static_pic_libs=None, static_pic_link=None, supported_platforms_regex=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_cxx_library_group',
        'name': name,
        'deps': deps,
        'exportedDeps': exported_deps,
        'exportedPreprocessorFlags': exported_preprocessor_flags,
        'includeDirs': include_dirs,
        'labels': labels,
        'licenses': licenses,
        'providedSharedLibs': provided_shared_libs,
        'sharedLibs': shared_libs,
        'sharedLink': shared_link,
        'staticLibs': static_libs,
        'staticLink': static_link,
        'staticPicLibs': static_pic_libs,
        'staticPicLink': static_pic_link,
        'supportedPlatformsRegex': supported_platforms_regex,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_precompiled_header(name, src, deps=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_precompiled_header',
        'name': name,
        'src': src,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def lua_library(name, base_module=None, deps=None, labels=None, licenses=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'lua_library',
        'name': name,
        'baseModule': base_module,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def core_data_model(name, path, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'core_data_model',
        'name': name,
        'path': path,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def gwt_binary(name, deps=None, draft_compile=None, experimental_args=None, labels=None, licenses=None, local_workers=None, module_deps=None, modules=None, optimize=None, strict=None, style=None, vm_args=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'gwt_binary',
        'name': name,
        'deps': deps,
        'draftCompile': draft_compile,
        'experimentalArgs': experimental_args,
        'labels': labels,
        'licenses': licenses,
        'localWorkers': local_workers,
        'moduleDeps': module_deps,
        'modules': modules,
        'optimize': optimize,
        'strict': strict,
        'style': style,
        'vmArgs': vm_args,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_manifest(name, skeleton, deps=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_manifest',
        'name': name,
        'skeleton': skeleton,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def groovy_test(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, contacts=None, deps=None, env=None, exported_deps=None, extra_arguments=None, extra_groovyc_arguments=None, fork_mode=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, run_test_separately=None, source=None, srcs=None, std_err_log_level=None, std_out_log_level=None, target=None, test_case_timeout_ms=None, test_rule_timeout_ms=None, test_type=None, tests=None, vm_args=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'groovy_test',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'contacts': contacts,
        'deps': deps,
        'env': env,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'extraGroovycArguments': extra_groovyc_arguments,
        'forkMode': fork_mode,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'runTestSeparately': run_test_separately,
        'source': source,
        'srcs': srcs,
        'stdErrLogLevel': std_err_log_level,
        'stdOutLogLevel': std_out_log_level,
        'target': target,
        'testCaseTimeoutMs': test_case_timeout_ms,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'testType': test_type,
        'tests': tests,
        'vmArgs': vm_args,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_resource(name, dirs=None, files=None, labels=None, licenses=None, variants=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_resource',
        'name': name,
        'dirs': dirs,
        'files': files,
        'labels': labels,
        'licenses': licenses,
        'variants': variants,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def d_library(name, srcs, deps=None, labels=None, licenses=None, linker_flags=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'd_library',
        'name': name,
        'srcs': srcs,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_ocaml_library(name, bytecode_lib=None, bytecode_only=None, c_libs=None, deps=None, include_dir=None, labels=None, lib_dir=None, lib_name=None, licenses=None, native_lib=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_ocaml_library',
        'name': name,
        'bytecodeLib': bytecode_lib,
        'bytecodeOnly': bytecode_only,
        'cLibs': c_libs,
        'deps': deps,
        'includeDir': include_dir,
        'labels': labels,
        'libDir': lib_dir,
        'libName': lib_name,
        'licenses': licenses,
        'nativeLib': native_lib,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_jar(name, binary_jar, deps=None, gwt_jar=None, javadoc_url=None, labels=None, licenses=None, maven_coords=None, provided=None, source_jar=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_jar',
        'name': name,
        'binaryJar': binary_jar,
        'deps': deps,
        'gwtJar': gwt_jar,
        'javadocUrl': javadoc_url,
        'labels': labels,
        'licenses': licenses,
        'mavenCoords': maven_coords,
        'provided': provided,
        'sourceJar': source_jar,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_resource(name, assets=None, deps=None, has_whitelisted_strings=None, labels=None, licenses=None, manifest=None, package=None, project_assets=None, project_res=None, res=None, resource_union=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_resource',
        'name': name,
        'assets': assets,
        'deps': deps,
        'hasWhitelistedStrings': has_whitelisted_strings,
        'labels': labels,
        'licenses': licenses,
        'manifest': manifest,
        'package': package,
        'projectAssets': project_assets,
        'projectRes': project_res,
        'res': res,
        'resourceUnion': resource_union,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def export_file(name, labels=None, licenses=None, mode=None, out=None, src=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'export_file',
        'name': name,
        'labels': labels,
        'licenses': licenses,
        'mode': mode,
        'out': out,
        'src': src,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_library(name, bridging_header=None, can_be_asset=None, compiler_flags=None, configs=None, cxx_runtime_type=None, defaults=None, deps=None, exported_deps=None, exported_headers=None, exported_lang_preprocessor_flags=None, exported_linker_flags=None, exported_platform_deps=None, exported_platform_headers=None, exported_platform_linker_flags=None, exported_platform_preprocessor_flags=None, exported_preprocessor_flags=None, extra_xcode_files=None, extra_xcode_sources=None, force_static=None, frameworks=None, header_namespace=None, header_path_prefix=None, headers=None, include_dirs=None, info_plist=None, info_plist_substitutions=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, link_whole=None, linker_flags=None, modular=None, module_name=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, preferred_linkage=None, prefix_header=None, preprocessor_flags=None, reexport_all_header_dependencies=None, soname=None, srcs=None, supported_platforms_regex=None, swift_compiler_flags=None, tests=None, thin_lto=None, xcode_private_headers_symlinks=None, xcode_public_headers_symlinks=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_library',
        'name': name,
        'bridgingHeader': bridging_header,
        'canBeAsset': can_be_asset,
        'compilerFlags': compiler_flags,
        'configs': configs,
        'cxxRuntimeType': cxx_runtime_type,
        'defaults': defaults,
        'deps': deps,
        'exportedDeps': exported_deps,
        'exportedHeaders': exported_headers,
        'exportedLangPreprocessorFlags': exported_lang_preprocessor_flags,
        'exportedLinkerFlags': exported_linker_flags,
        'exportedPlatformDeps': exported_platform_deps,
        'exportedPlatformHeaders': exported_platform_headers,
        'exportedPlatformLinkerFlags': exported_platform_linker_flags,
        'exportedPlatformPreprocessorFlags': exported_platform_preprocessor_flags,
        'exportedPreprocessorFlags': exported_preprocessor_flags,
        'extraXcodeFiles': extra_xcode_files,
        'extraXcodeSources': extra_xcode_sources,
        'forceStatic': force_static,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headerPathPrefix': header_path_prefix,
        'headers': headers,
        'includeDirs': include_dirs,
        'infoPlist': info_plist,
        'infoPlistSubstitutions': info_plist_substitutions,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkWhole': link_whole,
        'linkerFlags': linker_flags,
        'modular': modular,
        'moduleName': module_name,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'preferredLinkage': preferred_linkage,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'reexportAllHeaderDependencies': reexport_all_header_dependencies,
        'soname': soname,
        'srcs': srcs,
        'supportedPlatformsRegex': supported_platforms_regex,
        'swiftCompilerFlags': swift_compiler_flags,
        'tests': tests,
        'thinLto': thin_lto,
        'xcodePrivateHeadersSymlinks': xcode_private_headers_symlinks,
        'xcodePublicHeadersSymlinks': xcode_public_headers_symlinks,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_react_native_library(name, bundle_name, entry_path, deps=None, labels=None, licenses=None, package=None, packager_flags=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_react_native_library',
        'name': name,
        'bundleName': bundle_name,
        'entryPath': entry_path,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'package': package,
        'packagerFlags': packager_flags,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def swift_library(name, bridging_header=None, compiler_flags=None, deps=None, enable_objc_interop=None, frameworks=None, labels=None, libraries=None, licenses=None, module_name=None, preferred_linkage=None, soname=None, srcs=None, supported_platforms_regex=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'swift_library',
        'name': name,
        'bridgingHeader': bridging_header,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'enableObjcInterop': enable_objc_interop,
        'frameworks': frameworks,
        'labels': labels,
        'libraries': libraries,
        'licenses': licenses,
        'moduleName': module_name,
        'preferredLinkage': preferred_linkage,
        'soname': soname,
        'srcs': srcs,
        'supportedPlatformsRegex': supported_platforms_regex,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_binary(name, compiler_flags=None, cxx_runtime_type=None, default_platform=None, defaults=None, deps=None, deps_query=None, frameworks=None, header_namespace=None, headers=None, include_dirs=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, linker_flags=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, prefix_header=None, preprocessor_flags=None, srcs=None, tests=None, thin_lto=None, version_universe=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_binary',
        'name': name,
        'compilerFlags': compiler_flags,
        'cxxRuntimeType': cxx_runtime_type,
        'defaultPlatform': default_platform,
        'defaults': defaults,
        'deps': deps,
        'depsQuery': deps_query,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headers': headers,
        'includeDirs': include_dirs,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkerFlags': linker_flags,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'srcs': srcs,
        'tests': tests,
        'thinLto': thin_lto,
        'versionUniverse': version_universe,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_lua_extension(name, base_module=None, compiler_flags=None, cxx_runtime_type=None, defaults=None, deps=None, frameworks=None, header_namespace=None, headers=None, include_dirs=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, linker_flags=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, prefix_header=None, preprocessor_flags=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_lua_extension',
        'name': name,
        'baseModule': base_module,
        'compilerFlags': compiler_flags,
        'cxxRuntimeType': cxx_runtime_type,
        'defaults': defaults,
        'deps': deps,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headers': headers,
        'includeDirs': include_dirs,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_prebuilt_aar(name, aar, deps=None, javadoc_url=None, labels=None, licenses=None, source_jar=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_prebuilt_aar',
        'name': name,
        'aar': aar,
        'deps': deps,
        'javadocUrl': javadoc_url,
        'labels': labels,
        'licenses': licenses,
        'sourceJar': source_jar,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_library(name, bridging_header=None, can_be_asset=None, compiler_flags=None, cxx_runtime_type=None, defaults=None, deps=None, exported_deps=None, exported_headers=None, exported_lang_preprocessor_flags=None, exported_linker_flags=None, exported_platform_deps=None, exported_platform_headers=None, exported_platform_linker_flags=None, exported_platform_preprocessor_flags=None, exported_preprocessor_flags=None, extra_xcode_files=None, extra_xcode_sources=None, force_static=None, frameworks=None, header_namespace=None, headers=None, include_dirs=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, link_whole=None, linker_flags=None, module_name=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, preferred_linkage=None, prefix_header=None, preprocessor_flags=None, reexport_all_header_dependencies=None, soname=None, srcs=None, supported_platforms_regex=None, tests=None, thin_lto=None, xcode_private_headers_symlinks=None, xcode_public_headers_symlinks=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_library',
        'name': name,
        'bridgingHeader': bridging_header,
        'canBeAsset': can_be_asset,
        'compilerFlags': compiler_flags,
        'cxxRuntimeType': cxx_runtime_type,
        'defaults': defaults,
        'deps': deps,
        'exportedDeps': exported_deps,
        'exportedHeaders': exported_headers,
        'exportedLangPreprocessorFlags': exported_lang_preprocessor_flags,
        'exportedLinkerFlags': exported_linker_flags,
        'exportedPlatformDeps': exported_platform_deps,
        'exportedPlatformHeaders': exported_platform_headers,
        'exportedPlatformLinkerFlags': exported_platform_linker_flags,
        'exportedPlatformPreprocessorFlags': exported_platform_preprocessor_flags,
        'exportedPreprocessorFlags': exported_preprocessor_flags,
        'extraXcodeFiles': extra_xcode_files,
        'extraXcodeSources': extra_xcode_sources,
        'forceStatic': force_static,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headers': headers,
        'includeDirs': include_dirs,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkWhole': link_whole,
        'linkerFlags': linker_flags,
        'moduleName': module_name,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'preferredLinkage': preferred_linkage,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'reexportAllHeaderDependencies': reexport_all_header_dependencies,
        'soname': soname,
        'srcs': srcs,
        'supportedPlatformsRegex': supported_platforms_regex,
        'tests': tests,
        'thinLto': thin_lto,
        'xcodePrivateHeadersSymlinks': xcode_private_headers_symlinks,
        'xcodePublicHeadersSymlinks': xcode_public_headers_symlinks,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def go_binary(name, assembler_flags=None, compiler_flags=None, deps=None, labels=None, licenses=None, linker_flags=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'go_binary',
        'name': name,
        'assemblerFlags': assembler_flags,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def java_binary(name, blacklist=None, deps=None, labels=None, licenses=None, main_class=None, manifest_file=None, merge_manifests=None, meta_inf_directory=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'java_binary',
        'name': name,
        'blacklist': blacklist,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'mainClass': main_class,
        'manifestFile': manifest_file,
        'mergeManifests': merge_manifests,
        'metaInfDirectory': meta_inf_directory,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def genrule(name, out, bash=None, cmd=None, cmd_exe=None, executable=None, labels=None, licenses=None, srcs=None, tests=None, type=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'genrule',
        'name': name,
        'out': out,
        'bash': bash,
        'cmd': cmd,
        'cmdExe': cmd_exe,
        'executable': executable,
        'labels': labels,
        'licenses': licenses,
        'srcs': srcs,
        'tests': tests,
        'type': type,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def haskell_prebuilt_library(name, db, version, cxx_header_dirs=None, deps=None, exported_compiler_flags=None, exported_linker_flags=None, id=None, import_dirs=None, labels=None, licenses=None, shared_libs=None, static_libs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'haskell_prebuilt_library',
        'name': name,
        'db': db,
        'version': version,
        'cxxHeaderDirs': cxx_header_dirs,
        'deps': deps,
        'exportedCompilerFlags': exported_compiler_flags,
        'exportedLinkerFlags': exported_linker_flags,
        'id': id,
        'importDirs': import_dirs,
        'labels': labels,
        'licenses': licenses,
        'sharedLibs': shared_libs,
        'staticLibs': static_libs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def ios_react_native_library(name, bundle_name, entry_path, deps=None, labels=None, licenses=None, packager_flags=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'ios_react_native_library',
        'name': name,
        'bundleName': bundle_name,
        'entryPath': entry_path,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'packagerFlags': packager_flags,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def lua_binary(name, main_module, deps=None, labels=None, licenses=None, native_starter_library=None, package_style=None, python_platform=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'lua_binary',
        'name': name,
        'mainModule': main_module,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'nativeStarterLibrary': native_starter_library,
        'packageStyle': package_style,
        'pythonPlatform': python_platform,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_asset_catalog(name, app_icon=None, dirs=None, labels=None, launch_image=None, licenses=None, optimization=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_asset_catalog',
        'name': name,
        'appIcon': app_icon,
        'dirs': dirs,
        'labels': labels,
        'launchImage': launch_image,
        'licenses': licenses,
        'optimization': optimization,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def xcode_postbuild_script(name, cmd, labels=None, licenses=None, outputs=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'xcode_postbuild_script',
        'name': name,
        'cmd': cmd,
        'labels': labels,
        'licenses': licenses,
        'outputs': outputs,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def rust_test(name, contacts=None, crate=None, crate_root=None, deps=None, features=None, framework=None, labels=None, licenses=None, link_style=None, linker_flags=None, rpath=None, rustc_flags=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'rust_test',
        'name': name,
        'contacts': contacts,
        'crate': crate,
        'crateRoot': crate_root,
        'deps': deps,
        'features': features,
        'framework': framework,
        'labels': labels,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkerFlags': linker_flags,
        'rpath': rpath,
        'rustcFlags': rustc_flags,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def ocaml_binary(name, bytecode_only=None, compiler_flags=None, deps=None, labels=None, licenses=None, linker_flags=None, srcs=None, warnings_flags=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'ocaml_binary',
        'name': name,
        'bytecodeOnly': bytecode_only,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'srcs': srcs,
        'warningsFlags': warnings_flags,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def csharp_library(name, framework_ver, deps=None, dll_name=None, labels=None, licenses=None, resources=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'csharp_library',
        'name': name,
        'frameworkVer': framework_ver,
        'deps': deps,
        'dllName': dll_name,
        'labels': labels,
        'licenses': licenses,
        'resources': resources,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def scene_kit_assets(name, path, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'scene_kit_assets',
        'name': name,
        'path': path,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_rust_library(name, rlib, crate=None, deps=None, labels=None, licenses=None, link_style=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_rust_library',
        'name': name,
        'rlib': rlib,
        'crate': crate,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkStyle': link_style,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def d_binary(name, srcs, deps=None, labels=None, licenses=None, linker_flags=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'd_binary',
        'name': name,
        'srcs': srcs,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def zip_file(name, deps=None, labels=None, licenses=None, out=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'zip_file',
        'name': name,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'out': out,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def sh_test(name, args=None, contacts=None, deps=None, env=None, labels=None, licenses=None, resources=None, run_test_separately=None, test=None, test_rule_timeout_ms=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'sh_test',
        'name': name,
        'args': args,
        'contacts': contacts,
        'deps': deps,
        'env': env,
        'labels': labels,
        'licenses': licenses,
        'resources': resources,
        'runTestSeparately': run_test_separately,
        'test': test,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_library(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, deps=None, deps_query=None, exported_deps=None, extra_arguments=None, final_r_name=None, generate_abi_from_source=None, java_version=None, javac=None, javac_jar=None, labels=None, language=None, licenses=None, manifest=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, provided_deps_query=None, remove_classes=None, resource_union_package=None, resources=None, resources_root=None, source=None, srcs=None, target=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_library',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'deps': deps,
        'depsQuery': deps_query,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'finalRName': final_r_name,
        'generateAbiFromSource': generate_abi_from_source,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'language': language,
        'licenses': licenses,
        'manifest': manifest,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'providedDepsQuery': provided_deps_query,
        'removeClasses': remove_classes,
        'resourceUnionPackage': resource_union_package,
        'resources': resources,
        'resourcesRoot': resources_root,
        'source': source,
        'srcs': srcs,
        'target': target,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_test(name, info_plist, bridging_header=None, can_be_asset=None, compiler_flags=None, configs=None, contacts=None, cxx_runtime_type=None, defaults=None, deps=None, destination_specifier=None, exported_deps=None, exported_headers=None, exported_lang_preprocessor_flags=None, exported_linker_flags=None, exported_platform_deps=None, exported_platform_headers=None, exported_platform_linker_flags=None, exported_platform_preprocessor_flags=None, exported_preprocessor_flags=None, extra_xcode_files=None, extra_xcode_sources=None, force_static=None, frameworks=None, header_namespace=None, header_path_prefix=None, headers=None, include_dirs=None, info_plist_substitutions=None, is_ui_test=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, link_whole=None, linker_flags=None, module_name=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, preferred_linkage=None, prefix_header=None, preprocessor_flags=None, reexport_all_header_dependencies=None, run_test_separately=None, snapshot_reference_images_path=None, soname=None, srcs=None, supported_platforms_regex=None, swift_compiler_flags=None, test_host_app=None, test_rule_timeout_ms=None, tests=None, thin_lto=None, xcode_private_headers_symlinks=None, xcode_product_type=None, xcode_public_headers_symlinks=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_test',
        'name': name,
        'infoPlist': info_plist,
        'bridgingHeader': bridging_header,
        'canBeAsset': can_be_asset,
        'compilerFlags': compiler_flags,
        'configs': configs,
        'contacts': contacts,
        'cxxRuntimeType': cxx_runtime_type,
        'defaults': defaults,
        'deps': deps,
        'destinationSpecifier': destination_specifier,
        'exportedDeps': exported_deps,
        'exportedHeaders': exported_headers,
        'exportedLangPreprocessorFlags': exported_lang_preprocessor_flags,
        'exportedLinkerFlags': exported_linker_flags,
        'exportedPlatformDeps': exported_platform_deps,
        'exportedPlatformHeaders': exported_platform_headers,
        'exportedPlatformLinkerFlags': exported_platform_linker_flags,
        'exportedPlatformPreprocessorFlags': exported_platform_preprocessor_flags,
        'exportedPreprocessorFlags': exported_preprocessor_flags,
        'extraXcodeFiles': extra_xcode_files,
        'extraXcodeSources': extra_xcode_sources,
        'forceStatic': force_static,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headerPathPrefix': header_path_prefix,
        'headers': headers,
        'includeDirs': include_dirs,
        'infoPlistSubstitutions': info_plist_substitutions,
        'isUiTest': is_ui_test,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkWhole': link_whole,
        'linkerFlags': linker_flags,
        'moduleName': module_name,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'preferredLinkage': preferred_linkage,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'reexportAllHeaderDependencies': reexport_all_header_dependencies,
        'runTestSeparately': run_test_separately,
        'snapshotReferenceImagesPath': snapshot_reference_images_path,
        'soname': soname,
        'srcs': srcs,
        'supportedPlatformsRegex': supported_platforms_regex,
        'swiftCompilerFlags': swift_compiler_flags,
        'testHostApp': test_host_app,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'tests': tests,
        'thinLto': thin_lto,
        'xcodePrivateHeadersSymlinks': xcode_private_headers_symlinks,
        'xcodeProductType': xcode_product_type,
        'xcodePublicHeadersSymlinks': xcode_public_headers_symlinks,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apk_genrule(name, apk, out, bash=None, cacheable=None, cmd=None, cmd_exe=None, labels=None, licenses=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apk_genrule',
        'name': name,
        'apk': apk,
        'out': out,
        'bash': bash,
        'cacheable': cacheable,
        'cmd': cmd,
        'cmdExe': cmd_exe,
        'labels': labels,
        'licenses': licenses,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def js_library(name, worker, base_path=None, extra_args=None, labels=None, libs=None, licenses=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'js_library',
        'name': name,
        'worker': worker,
        'basePath': base_path,
        'extraArgs': extra_args,
        'labels': labels,
        'libs': libs,
        'licenses': licenses,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_instrumentation_test(name, apk, contacts=None, labels=None, licenses=None, test_rule_timeout_ms=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_instrumentation_test',
        'name': name,
        'apk': apk,
        'contacts': contacts,
        'labels': labels,
        'licenses': licenses,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def python_test(name, base_module=None, build_args=None, contacts=None, cxx_platform=None, deps=None, env=None, extension=None, labels=None, licenses=None, linker_flags=None, main_module=None, needed_coverage=None, package_style=None, platform=None, platform_deps=None, platform_resources=None, platform_srcs=None, preload_deps=None, resources=None, srcs=None, test_rule_timeout_ms=None, tests=None, version_universe=None, versioned_resources=None, versioned_srcs=None, zip_safe=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'python_test',
        'name': name,
        'baseModule': base_module,
        'buildArgs': build_args,
        'contacts': contacts,
        'cxxPlatform': cxx_platform,
        'deps': deps,
        'env': env,
        'extension': extension,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'mainModule': main_module,
        'neededCoverage': needed_coverage,
        'packageStyle': package_style,
        'platform': platform,
        'platformDeps': platform_deps,
        'platformResources': platform_resources,
        'platformSrcs': platform_srcs,
        'preloadDeps': preload_deps,
        'resources': resources,
        'srcs': srcs,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'tests': tests,
        'versionUniverse': version_universe,
        'versionedResources': versioned_resources,
        'versionedSrcs': versioned_srcs,
        'zipSafe': zip_safe,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def graphql_library(name, deps=None, labels=None, licenses=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'graphql_library',
        'name': name,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def remote_file(name, sha1, url, labels=None, licenses=None, out=None, type=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'remote_file',
        'name': name,
        'sha1': sha1,
        'url': url,
        'labels': labels,
        'licenses': licenses,
        'out': out,
        'type': type,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def versioned_alias(name, labels=None, licenses=None, versions=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'versioned_alias',
        'name': name,
        'labels': labels,
        'licenses': licenses,
        'versions': versions,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def kotlin_test(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, contacts=None, deps=None, env=None, exported_deps=None, extra_arguments=None, extra_kotlinc_arguments=None, fork_mode=None, generate_abi_from_source=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, run_test_separately=None, source=None, srcs=None, std_err_log_level=None, std_out_log_level=None, target=None, test_case_timeout_ms=None, test_rule_timeout_ms=None, test_type=None, tests=None, vm_args=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'kotlin_test',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'contacts': contacts,
        'deps': deps,
        'env': env,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'extraKotlincArguments': extra_kotlinc_arguments,
        'forkMode': fork_mode,
        'generateAbiFromSource': generate_abi_from_source,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'runTestSeparately': run_test_separately,
        'source': source,
        'srcs': srcs,
        'stdErrLogLevel': std_err_log_level,
        'stdOutLogLevel': std_out_log_level,
        'target': target,
        'testCaseTimeoutMs': test_case_timeout_ms,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'testType': test_type,
        'tests': tests,
        'vmArgs': vm_args,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def scala_test(name, contacts=None, cxx_library_whitelist=None, deps=None, env=None, extra_arguments=None, fork_mode=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, provided_deps=None, resources=None, resources_root=None, run_test_separately=None, srcs=None, std_err_log_level=None, std_out_log_level=None, test_case_timeout_ms=None, test_rule_timeout_ms=None, test_type=None, tests=None, use_cxx_libraries=None, vm_args=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'scala_test',
        'name': name,
        'contacts': contacts,
        'cxxLibraryWhitelist': cxx_library_whitelist,
        'deps': deps,
        'env': env,
        'extraArguments': extra_arguments,
        'forkMode': fork_mode,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'providedDeps': provided_deps,
        'resources': resources,
        'resourcesRoot': resources_root,
        'runTestSeparately': run_test_separately,
        'srcs': srcs,
        'stdErrLogLevel': std_err_log_level,
        'stdOutLogLevel': std_out_log_level,
        'testCaseTimeoutMs': test_case_timeout_ms,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'testType': test_type,
        'tests': tests,
        'useCxxLibraries': use_cxx_libraries,
        'vmArgs': vm_args,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def go_test(name, assembler_flags=None, compiler_flags=None, contacts=None, deps=None, labels=None, library=None, licenses=None, linker_flags=None, package_name=None, resources=None, run_test_separately=None, srcs=None, test_rule_timeout_ms=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'go_test',
        'name': name,
        'assemblerFlags': assembler_flags,
        'compilerFlags': compiler_flags,
        'contacts': contacts,
        'deps': deps,
        'labels': labels,
        'library': library,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'packageName': package_name,
        'resources': resources,
        'runTestSeparately': run_test_separately,
        'srcs': srcs,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_cxx_library(name, can_be_asset=None, deps=None, exported_deps=None, exported_headers=None, exported_lang_preprocessor_flags=None, exported_linker_flags=None, exported_platform_headers=None, exported_platform_linker_flags=None, exported_platform_preprocessor_flags=None, exported_preprocessor_flags=None, force_static=None, frameworks=None, header_namespace=None, header_only=None, include_dirs=None, labels=None, lib_dir=None, lib_name=None, libraries=None, licenses=None, link_whole=None, link_without_soname=None, preferred_linkage=None, provided=None, soname=None, supported_platforms_regex=None, supports_shared_library_interface=None, versioned_sub_dir=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_cxx_library',
        'name': name,
        'canBeAsset': can_be_asset,
        'deps': deps,
        'exportedDeps': exported_deps,
        'exportedHeaders': exported_headers,
        'exportedLangPreprocessorFlags': exported_lang_preprocessor_flags,
        'exportedLinkerFlags': exported_linker_flags,
        'exportedPlatformHeaders': exported_platform_headers,
        'exportedPlatformLinkerFlags': exported_platform_linker_flags,
        'exportedPlatformPreprocessorFlags': exported_platform_preprocessor_flags,
        'exportedPreprocessorFlags': exported_preprocessor_flags,
        'forceStatic': force_static,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headerOnly': header_only,
        'includeDirs': include_dirs,
        'labels': labels,
        'libDir': lib_dir,
        'libName': lib_name,
        'libraries': libraries,
        'licenses': licenses,
        'linkWhole': link_whole,
        'linkWithoutSoname': link_without_soname,
        'preferredLinkage': preferred_linkage,
        'provided': provided,
        'soname': soname,
        'supportedPlatformsRegex': supported_platforms_regex,
        'supportsSharedLibraryInterface': supports_shared_library_interface,
        'versionedSubDir': versioned_sub_dir,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def haskell_library(name, compiler_flags=None, deps=None, labels=None, licenses=None, link_whole=None, platform_deps=None, preferred_linkage=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'haskell_library',
        'name': name,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkWhole': link_whole,
        'platformDeps': platform_deps,
        'preferredLinkage': preferred_linkage,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def haskell_binary(name, compiler_flags=None, deps=None, deps_query=None, labels=None, licenses=None, link_style=None, main=None, platform_deps=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'haskell_binary',
        'name': name,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'depsQuery': deps_query,
        'labels': labels,
        'licenses': licenses,
        'linkStyle': link_style,
        'main': main,
        'platformDeps': platform_deps,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def xcode_prebuild_script(name, cmd, labels=None, licenses=None, outputs=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'xcode_prebuild_script',
        'name': name,
        'cmd': cmd,
        'labels': labels,
        'licenses': licenses,
        'outputs': outputs,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def kotlin_library(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, deps=None, exported_deps=None, extra_arguments=None, extra_kotlinc_arguments=None, generate_abi_from_source=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, source=None, srcs=None, target=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'kotlin_library',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'deps': deps,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'extraKotlincArguments': extra_kotlinc_arguments,
        'generateAbiFromSource': generate_abi_from_source,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'source': source,
        'srcs': srcs,
        'target': target,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_package(name, bundle, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_package',
        'name': name,
        'bundle': bundle,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def groovy_library(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, deps=None, exported_deps=None, extra_arguments=None, extra_groovyc_arguments=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, source=None, srcs=None, target=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'groovy_library',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'deps': deps,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'extraGroovycArguments': extra_groovyc_arguments,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'source': source,
        'srcs': srcs,
        'target': target,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def gen_aidl(name, aidl, import_path, deps=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'gen_aidl',
        'name': name,
        'aidl': aidl,
        'importPath': import_path,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_build_config(name, package, labels=None, licenses=None, values=None, values_file=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_build_config',
        'name': name,
        'package': package,
        'labels': labels,
        'licenses': licenses,
        'values': values,
        'valuesFile': values_file,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_aar(name, manifest_skeleton, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, build_config_values=None, compiler=None, compiler_class_name=None, deps=None, deps_query=None, exported_deps=None, extra_arguments=None, final_r_name=None, generate_abi_from_source=None, include_build_config_class=None, java_version=None, javac=None, javac_jar=None, labels=None, language=None, licenses=None, manifest=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, provided_deps_query=None, remove_classes=None, resource_union_package=None, resources=None, resources_root=None, source=None, srcs=None, target=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_aar',
        'name': name,
        'manifestSkeleton': manifest_skeleton,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'buildConfigValues': build_config_values,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'deps': deps,
        'depsQuery': deps_query,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'finalRName': final_r_name,
        'generateAbiFromSource': generate_abi_from_source,
        'includeBuildConfigClass': include_build_config_class,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'language': language,
        'licenses': licenses,
        'manifest': manifest,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'providedDepsQuery': provided_deps_query,
        'removeClasses': remove_classes,
        'resourceUnionPackage': resource_union_package,
        'resources': resources,
        'resourcesRoot': resources_root,
        'source': source,
        'srcs': srcs,
        'target': target,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def keystore(name, properties, store, deps=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'keystore',
        'name': name,
        'properties': properties,
        'store': store,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_bundle(name, binary, extension, info_plist, deps=None, info_plist_substitutions=None, labels=None, licenses=None, product_name=None, tests=None, xcode_product_type=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_bundle',
        'name': name,
        'binary': binary,
        'extension': extension,
        'infoPlist': info_plist,
        'deps': deps,
        'infoPlistSubstitutions': info_plist_substitutions,
        'labels': labels,
        'licenses': licenses,
        'productName': product_name,
        'tests': tests,
        'xcodeProductType': xcode_product_type,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def sh_binary(name, main, deps=None, labels=None, licenses=None, resources=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'sh_binary',
        'name': name,
        'main': main,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'resources': resources,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def rust_library(name, crate=None, crate_root=None, deps=None, features=None, labels=None, licenses=None, preferred_linkage=None, rustc_flags=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'rust_library',
        'name': name,
        'crate': crate,
        'crateRoot': crate_root,
        'deps': deps,
        'features': features,
        'labels': labels,
        'licenses': licenses,
        'preferredLinkage': preferred_linkage,
        'rustcFlags': rustc_flags,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def java_test(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, contacts=None, cxx_library_whitelist=None, deps=None, env=None, exported_deps=None, extra_arguments=None, fork_mode=None, generate_abi_from_source=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, run_test_separately=None, source=None, srcs=None, std_err_log_level=None, std_out_log_level=None, target=None, test_case_timeout_ms=None, test_rule_timeout_ms=None, test_type=None, tests=None, use_cxx_libraries=None, vm_args=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'java_test',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'contacts': contacts,
        'cxxLibraryWhitelist': cxx_library_whitelist,
        'deps': deps,
        'env': env,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'forkMode': fork_mode,
        'generateAbiFromSource': generate_abi_from_source,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'runTestSeparately': run_test_separately,
        'source': source,
        'srcs': srcs,
        'stdErrLogLevel': std_err_log_level,
        'stdOutLogLevel': std_out_log_level,
        'target': target,
        'testCaseTimeoutMs': test_case_timeout_ms,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'testType': test_type,
        'tests': tests,
        'useCxxLibraries': use_cxx_libraries,
        'vmArgs': vm_args,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def d_test(name, srcs, contacts=None, deps=None, labels=None, licenses=None, linker_flags=None, test_rule_timeout_ms=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'd_test',
        'name': name,
        'srcs': srcs,
        'contacts': contacts,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def worker_tool(name, exe, args=None, env=None, labels=None, licenses=None, max_workers=None, persistent=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'worker_tool',
        'name': name,
        'exe': exe,
        'args': args,
        'env': env,
        'labels': labels,
        'licenses': licenses,
        'maxWorkers': max_workers,
        'persistent': persistent,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def python_binary(name, base_module=None, build_args=None, cxx_platform=None, deps=None, extension=None, labels=None, licenses=None, linker_flags=None, main=None, main_module=None, package_style=None, platform=None, platform_deps=None, preload_deps=None, tests=None, version_universe=None, zip_safe=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'python_binary',
        'name': name,
        'baseModule': base_module,
        'buildArgs': build_args,
        'cxxPlatform': cxx_platform,
        'deps': deps,
        'extension': extension,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'main': main,
        'mainModule': main_module,
        'packageStyle': package_style,
        'platform': platform,
        'platformDeps': platform_deps,
        'preloadDeps': preload_deps,
        'tests': tests,
        'versionUniverse': version_universe,
        'zipSafe': zip_safe,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_test(name, additional_coverage_targets=None, args=None, compiler_flags=None, contacts=None, cxx_runtime_type=None, default_platform=None, defaults=None, deps=None, deps_query=None, env=None, framework=None, frameworks=None, header_namespace=None, headers=None, include_dirs=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, linker_flags=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, prefix_header=None, preprocessor_flags=None, resources=None, run_test_separately=None, srcs=None, test_rule_timeout_ms=None, tests=None, thin_lto=None, use_default_test_main=None, version_universe=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_test',
        'name': name,
        'additionalCoverageTargets': additional_coverage_targets,
        'args': args,
        'compilerFlags': compiler_flags,
        'contacts': contacts,
        'cxxRuntimeType': cxx_runtime_type,
        'defaultPlatform': default_platform,
        'defaults': defaults,
        'deps': deps,
        'depsQuery': deps_query,
        'env': env,
        'framework': framework,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headers': headers,
        'includeDirs': include_dirs,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkerFlags': linker_flags,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'resources': resources,
        'runTestSeparately': run_test_separately,
        'srcs': srcs,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'tests': tests,
        'thinLto': thin_lto,
        'useDefaultTestMain': use_default_test_main,
        'versionUniverse': version_universe,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def python_library(name, base_module=None, deps=None, labels=None, licenses=None, platform_deps=None, platform_resources=None, platform_srcs=None, resources=None, srcs=None, tests=None, versioned_resources=None, versioned_srcs=None, zip_safe=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'python_library',
        'name': name,
        'baseModule': base_module,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'platformDeps': platform_deps,
        'platformResources': platform_resources,
        'platformSrcs': platform_srcs,
        'resources': resources,
        'srcs': srcs,
        'tests': tests,
        'versionedResources': versioned_resources,
        'versionedSrcs': versioned_srcs,
        'zipSafe': zip_safe,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def go_library(name, assembler_flags=None, compiler_flags=None, deps=None, exported_deps=None, labels=None, licenses=None, package_name=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'go_library',
        'name': name,
        'assemblerFlags': assembler_flags,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'exportedDeps': exported_deps,
        'labels': labels,
        'licenses': licenses,
        'packageName': package_name,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def rust_binary(name, crate=None, crate_root=None, deps=None, features=None, labels=None, licenses=None, link_style=None, linker_flags=None, rpath=None, rustc_flags=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'rust_binary',
        'name': name,
        'crate': crate,
        'crateRoot': crate_root,
        'deps': deps,
        'features': features,
        'labels': labels,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkerFlags': linker_flags,
        'rpath': rpath,
        'rustcFlags': rustc_flags,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_binary(name, keystore, manifest, aapt_mode=None, allowed_duplicate_resource_types=None, android_sdk_proguard_config=None, application_module_configs=None, application_module_targets=None, banned_duplicate_resource_types=None, build_config_values=None, build_config_values_file=None, build_string_source_map=None, compress_asset_libraries=None, cpu_filters=None, deps=None, dex_compression=None, dex_reorder_data_dump_file=None, dex_reorder_tool_file=None, disable_pre_dex=None, duplicate_resource_behavior=None, enable_relinker=None, exopackage=None, exopackage_modes=None, includes_vector_drawables=None, is_cacheable=None, keep_resource_pattern=None, labels=None, licenses=None, linear_alloc_hard_limit=None, locales=None, manifest_entries=None, minimize_primary_dex_size=None, native_library_merge_code_generator=None, native_library_merge_glue=None, native_library_merge_localized_symbols=None, native_library_merge_map=None, native_library_proguard_config_generator=None, no_dx=None, optimization_passes=None, package_asset_libraries=None, package_type=None, post_filter_resources_cmd=None, preprocess_java_classes_bash=None, preprocess_java_classes_deps=None, primary_dex_classes_file=None, primary_dex_patterns=None, primary_dex_scenario_file=None, primary_dex_scenario_overflow_allowed=None, proguard_config=None, proguard_jvm_args=None, redex=None, redex_config=None, redex_extra_args=None, reorder_classes_intra_dex=None, resource_compression=None, resource_filter=None, resource_union_package=None, secondary_dex_head_classes_file=None, secondary_dex_tail_classes_file=None, skip_crunch_pngs=None, skip_proguard=None, tests=None, trim_resource_ids=None, use_android_proguard_config_with_optimizations=None, use_split_dex=None, xz_compression_level=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_binary',
        'name': name,
        'keystore': keystore,
        'manifest': manifest,
        'aaptMode': aapt_mode,
        'allowedDuplicateResourceTypes': allowed_duplicate_resource_types,
        'androidSdkProguardConfig': android_sdk_proguard_config,
        'applicationModuleConfigs': application_module_configs,
        'applicationModuleTargets': application_module_targets,
        'bannedDuplicateResourceTypes': banned_duplicate_resource_types,
        'buildConfigValues': build_config_values,
        'buildConfigValuesFile': build_config_values_file,
        'buildStringSourceMap': build_string_source_map,
        'compressAssetLibraries': compress_asset_libraries,
        'cpuFilters': cpu_filters,
        'deps': deps,
        'dexCompression': dex_compression,
        'dexReorderDataDumpFile': dex_reorder_data_dump_file,
        'dexReorderToolFile': dex_reorder_tool_file,
        'disablePreDex': disable_pre_dex,
        'duplicateResourceBehavior': duplicate_resource_behavior,
        'enableRelinker': enable_relinker,
        'exopackage': exopackage,
        'exopackageModes': exopackage_modes,
        'includesVectorDrawables': includes_vector_drawables,
        'isCacheable': is_cacheable,
        'keepResourcePattern': keep_resource_pattern,
        'labels': labels,
        'licenses': licenses,
        'linearAllocHardLimit': linear_alloc_hard_limit,
        'locales': locales,
        'manifestEntries': manifest_entries,
        'minimizePrimaryDexSize': minimize_primary_dex_size,
        'nativeLibraryMergeCodeGenerator': native_library_merge_code_generator,
        'nativeLibraryMergeGlue': native_library_merge_glue,
        'nativeLibraryMergeLocalizedSymbols': native_library_merge_localized_symbols,
        'nativeLibraryMergeMap': native_library_merge_map,
        'nativeLibraryProguardConfigGenerator': native_library_proguard_config_generator,
        'noDx': no_dx,
        'optimizationPasses': optimization_passes,
        'packageAssetLibraries': package_asset_libraries,
        'packageType': package_type,
        'postFilterResourcesCmd': post_filter_resources_cmd,
        'preprocessJavaClassesBash': preprocess_java_classes_bash,
        'preprocessJavaClassesDeps': preprocess_java_classes_deps,
        'primaryDexClassesFile': primary_dex_classes_file,
        'primaryDexPatterns': primary_dex_patterns,
        'primaryDexScenarioFile': primary_dex_scenario_file,
        'primaryDexScenarioOverflowAllowed': primary_dex_scenario_overflow_allowed,
        'proguardConfig': proguard_config,
        'proguardJvmArgs': proguard_jvm_args,
        'redex': redex,
        'redexConfig': redex_config,
        'redexExtraArgs': redex_extra_args,
        'reorderClassesIntraDex': reorder_classes_intra_dex,
        'resourceCompression': resource_compression,
        'resourceFilter': resource_filter,
        'resourceUnionPackage': resource_union_package,
        'secondaryDexHeadClassesFile': secondary_dex_head_classes_file,
        'secondaryDexTailClassesFile': secondary_dex_tail_classes_file,
        'skipCrunchPngs': skip_crunch_pngs,
        'skipProguard': skip_proguard,
        'tests': tests,
        'trimResourceIds': trim_resource_ids,
        'useAndroidProguardConfigWithOptimizations': use_android_proguard_config_with_optimizations,
        'useSplitDex': use_split_dex,
        'xzCompressionLevel': xz_compression_level,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def halide_library(name, compiler_deps=None, compiler_flags=None, compiler_invocation_flags=None, configs=None, cxx_runtime_type=None, default_platform=None, defaults=None, deps=None, deps_query=None, frameworks=None, function_name=None, header_namespace=None, headers=None, include_dirs=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, linker_flags=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, prefix_header=None, preprocessor_flags=None, srcs=None, supported_platforms_regex=None, tests=None, thin_lto=None, version_universe=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'halide_library',
        'name': name,
        'compilerDeps': compiler_deps,
        'compilerFlags': compiler_flags,
        'compilerInvocationFlags': compiler_invocation_flags,
        'configs': configs,
        'cxxRuntimeType': cxx_runtime_type,
        'defaultPlatform': default_platform,
        'defaults': defaults,
        'deps': deps,
        'depsQuery': deps_query,
        'frameworks': frameworks,
        'functionName': function_name,
        'headerNamespace': header_namespace,
        'headers': headers,
        'includeDirs': include_dirs,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkerFlags': linker_flags,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'srcs': srcs,
        'supportedPlatformsRegex': supported_platforms_regex,
        'tests': tests,
        'thinLto': thin_lto,
        'versionUniverse': version_universe,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def ocaml_library(name, bytecode_only=None, compiler_flags=None, deps=None, labels=None, licenses=None, linker_flags=None, native_plugin=None, srcs=None, warnings_flags=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'ocaml_library',
        'name': name,
        'bytecodeOnly': bytecode_only,
        'compilerFlags': compiler_flags,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'nativePlugin': native_plugin,
        'srcs': srcs,
        'warningsFlags': warnings_flags,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def scala_library(name, deps=None, extra_arguments=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, provided_deps=None, resources=None, resources_root=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'scala_library',
        'name': name,
        'deps': deps,
        'extraArguments': extra_arguments,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'providedDeps': provided_deps,
        'resources': resources,
        'resourcesRoot': resources_root,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def ndk_library(name, deps=None, flags=None, is_asset=None, labels=None, licenses=None, srcs=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'ndk_library',
        'name': name,
        'deps': deps,
        'flags': flags,
        'isAsset': is_asset,
        'labels': labels,
        'licenses': licenses,
        'srcs': srcs,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def java_library(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, deps=None, exported_deps=None, extra_arguments=None, generate_abi_from_source=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, source=None, srcs=None, target=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'java_library',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'deps': deps,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'generateAbiFromSource': generate_abi_from_source,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'source': source,
        'srcs': srcs,
        'target': target,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def java_annotation_processor(name, processor_class, deps=None, does_not_affect_abi=None, isolate_class_loader=None, labels=None, licenses=None, supports_abi_generation_from_source=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'java_annotation_processor',
        'name': name,
        'processorClass': processor_class,
        'deps': deps,
        'doesNotAffectAbi': does_not_affect_abi,
        'isolateClassLoader': isolate_class_loader,
        'labels': labels,
        'licenses': licenses,
        'supportsAbiGenerationFromSource': supports_abi_generation_from_source,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_python_extension(name, base_module=None, compiler_flags=None, cxx_runtime_type=None, defaults=None, deps=None, frameworks=None, header_namespace=None, headers=None, include_dirs=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, linker_flags=None, module_name=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, prefix_header=None, preprocessor_flags=None, srcs=None, tests=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_python_extension',
        'name': name,
        'baseModule': base_module,
        'compilerFlags': compiler_flags,
        'cxxRuntimeType': cxx_runtime_type,
        'defaults': defaults,
        'deps': deps,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headers': headers,
        'includeDirs': include_dirs,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkerFlags': linker_flags,
        'moduleName': module_name,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'srcs': srcs,
        'tests': tests,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def apple_binary(name, bridging_header=None, can_be_asset=None, compiler_flags=None, configs=None, cxx_runtime_type=None, defaults=None, deps=None, exported_deps=None, exported_headers=None, exported_lang_preprocessor_flags=None, exported_linker_flags=None, exported_platform_deps=None, exported_platform_headers=None, exported_platform_linker_flags=None, exported_platform_preprocessor_flags=None, exported_preprocessor_flags=None, extra_xcode_files=None, extra_xcode_sources=None, force_static=None, frameworks=None, header_namespace=None, header_path_prefix=None, headers=None, include_dirs=None, info_plist=None, info_plist_substitutions=None, labels=None, lang_compiler_flags=None, lang_preprocessor_flags=None, libraries=None, licenses=None, link_style=None, link_whole=None, linker_flags=None, module_name=None, platform_compiler_flags=None, platform_deps=None, platform_headers=None, platform_linker_flags=None, platform_preprocessor_flags=None, platform_srcs=None, precompiled_header=None, preferred_linkage=None, prefix_header=None, preprocessor_flags=None, reexport_all_header_dependencies=None, soname=None, srcs=None, supported_platforms_regex=None, swift_compiler_flags=None, tests=None, thin_lto=None, xcode_private_headers_symlinks=None, xcode_public_headers_symlinks=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'apple_binary',
        'name': name,
        'bridgingHeader': bridging_header,
        'canBeAsset': can_be_asset,
        'compilerFlags': compiler_flags,
        'configs': configs,
        'cxxRuntimeType': cxx_runtime_type,
        'defaults': defaults,
        'deps': deps,
        'exportedDeps': exported_deps,
        'exportedHeaders': exported_headers,
        'exportedLangPreprocessorFlags': exported_lang_preprocessor_flags,
        'exportedLinkerFlags': exported_linker_flags,
        'exportedPlatformDeps': exported_platform_deps,
        'exportedPlatformHeaders': exported_platform_headers,
        'exportedPlatformLinkerFlags': exported_platform_linker_flags,
        'exportedPlatformPreprocessorFlags': exported_platform_preprocessor_flags,
        'exportedPreprocessorFlags': exported_preprocessor_flags,
        'extraXcodeFiles': extra_xcode_files,
        'extraXcodeSources': extra_xcode_sources,
        'forceStatic': force_static,
        'frameworks': frameworks,
        'headerNamespace': header_namespace,
        'headerPathPrefix': header_path_prefix,
        'headers': headers,
        'includeDirs': include_dirs,
        'infoPlist': info_plist,
        'infoPlistSubstitutions': info_plist_substitutions,
        'labels': labels,
        'langCompilerFlags': lang_compiler_flags,
        'langPreprocessorFlags': lang_preprocessor_flags,
        'libraries': libraries,
        'licenses': licenses,
        'linkStyle': link_style,
        'linkWhole': link_whole,
        'linkerFlags': linker_flags,
        'moduleName': module_name,
        'platformCompilerFlags': platform_compiler_flags,
        'platformDeps': platform_deps,
        'platformHeaders': platform_headers,
        'platformLinkerFlags': platform_linker_flags,
        'platformPreprocessorFlags': platform_preprocessor_flags,
        'platformSrcs': platform_srcs,
        'precompiledHeader': precompiled_header,
        'preferredLinkage': preferred_linkage,
        'prefixHeader': prefix_header,
        'preprocessorFlags': preprocessor_flags,
        'reexportAllHeaderDependencies': reexport_all_header_dependencies,
        'soname': soname,
        'srcs': srcs,
        'supportedPlatformsRegex': supported_platforms_regex,
        'swiftCompilerFlags': swift_compiler_flags,
        'tests': tests,
        'thinLto': thin_lto,
        'xcodePrivateHeadersSymlinks': xcode_private_headers_symlinks,
        'xcodePublicHeadersSymlinks': xcode_public_headers_symlinks,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_native_library(name, native_libs, deps=None, is_asset=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_native_library',
        'name': name,
        'nativeLibs': native_libs,
        'deps': deps,
        'isAsset': is_asset,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def xcode_workspace_config(name, action_config_names=None, explicit_runnable_path=None, extra_schemes=None, extra_targets=None, extra_tests=None, is_remote_runnable=None, labels=None, launch_style=None, licenses=None, src_target=None, workspace_name=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'xcode_workspace_config',
        'name': name,
        'actionConfigNames': action_config_names,
        'explicitRunnablePath': explicit_runnable_path,
        'extraSchemes': extra_schemes,
        'extraTargets': extra_targets,
        'extraTests': extra_tests,
        'isRemoteRunnable': is_remote_runnable,
        'labels': labels,
        'launchStyle': launch_style,
        'licenses': licenses,
        'srcTarget': src_target,
        'workspaceName': workspace_name,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def android_instrumentation_apk(name, apk, manifest, deps=None, includes_vector_drawables=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'android_instrumentation_apk',
        'name': name,
        'apk': apk,
        'manifest': manifest,
        'deps': deps,
        'includesVectorDrawables': includes_vector_drawables,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_dotnet_library(name, assembly, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_dotnet_library',
        'name': name,
        'assembly': assembly,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def robolectric_test(name, annotation_processor_deps=None, annotation_processor_only=None, annotation_processor_params=None, annotation_processors=None, autodeps=None, compiler=None, compiler_class_name=None, contacts=None, cxx_library_whitelist=None, deps=None, env=None, exported_deps=None, extra_arguments=None, force_final_resource_ids=None, fork_mode=None, generate_abi_from_source=None, java_version=None, javac=None, javac_jar=None, labels=None, licenses=None, manifest_file=None, maven_coords=None, maven_pom_template=None, plugins=None, postprocess_classes_commands=None, proguard_config=None, provided_deps=None, remove_classes=None, resources=None, resources_root=None, robolectric_manifest=None, robolectric_runtime_dependency=None, run_test_separately=None, source=None, srcs=None, std_err_log_level=None, std_out_log_level=None, target=None, test_case_timeout_ms=None, test_rule_timeout_ms=None, test_type=None, tests=None, use_cxx_libraries=None, use_old_styleable_format=None, vm_args=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'robolectric_test',
        'name': name,
        'annotationProcessorDeps': annotation_processor_deps,
        'annotationProcessorOnly': annotation_processor_only,
        'annotationProcessorParams': annotation_processor_params,
        'annotationProcessors': annotation_processors,
        'autodeps': autodeps,
        'compiler': compiler,
        'compilerClassName': compiler_class_name,
        'contacts': contacts,
        'cxxLibraryWhitelist': cxx_library_whitelist,
        'deps': deps,
        'env': env,
        'exportedDeps': exported_deps,
        'extraArguments': extra_arguments,
        'forceFinalResourceIds': force_final_resource_ids,
        'forkMode': fork_mode,
        'generateAbiFromSource': generate_abi_from_source,
        'javaVersion': java_version,
        'javac': javac,
        'javacJar': javac_jar,
        'labels': labels,
        'licenses': licenses,
        'manifestFile': manifest_file,
        'mavenCoords': maven_coords,
        'mavenPomTemplate': maven_pom_template,
        'plugins': plugins,
        'postprocessClassesCommands': postprocess_classes_commands,
        'proguardConfig': proguard_config,
        'providedDeps': provided_deps,
        'removeClasses': remove_classes,
        'resources': resources,
        'resourcesRoot': resources_root,
        'robolectricManifest': robolectric_manifest,
        'robolectricRuntimeDependency': robolectric_runtime_dependency,
        'runTestSeparately': run_test_separately,
        'source': source,
        'srcs': srcs,
        'stdErrLogLevel': std_err_log_level,
        'stdOutLogLevel': std_out_log_level,
        'target': target,
        'testCaseTimeoutMs': test_case_timeout_ms,
        'testRuleTimeoutMs': test_rule_timeout_ms,
        'testType': test_type,
        'tests': tests,
        'useCxxLibraries': use_cxx_libraries,
        'useOldStyleableFormat': use_old_styleable_format,
        'vmArgs': vm_args,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def prebuilt_python_library(name, binary_src, deps=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'prebuilt_python_library',
        'name': name,
        'binarySrc': binary_src,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def js_bundle(name, entry, worker, android_package=None, bundle_name=None, deps=None, labels=None, licenses=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'js_bundle',
        'name': name,
        'entry': entry,
        'worker': worker,
        'androidPackage': android_package,
        'bundleName': bundle_name,
        'deps': deps,
        'labels': labels,
        'licenses': licenses,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


@provide_for_build
def cxx_genrule(name, out, bash=None, cmd=None, cmd_exe=None, labels=None, licenses=None, srcs=None, tests=None, type=None, visibility=None, within_view=None, build_env=None):
    add_rule({
        'buck.type': 'cxx_genrule',
        'name': name,
        'out': out,
        'bash': bash,
        'cmd': cmd,
        'cmdExe': cmd_exe,
        'labels': labels,
        'licenses': licenses,
        'srcs': srcs,
        'tests': tests,
        'type': type,
        'visibility': visibility,
        'within_view': within_view,
    }, build_env)


